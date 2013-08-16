//
//  ZYPictureController.m
//  ZYMobCMS
//
//  Created by ZYVincent on 13-8-10.
//  Copyright (c) 2013年 ZYVincent. All rights reserved.
//

#import "ZYPictureController.h"
#import "BFNImagePreViewController.h"
#import "ZYPicturePreViewController.h"

#define PageSize 10

@interface ZYPictureController ()

@end

@implementation ZYPictureController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)dealloc
{
    [sourceArray release];
    [super dealloc];
}
- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
    sourceArray = [[NSMutableArray alloc]init];
    listTable = [[UITableView alloc]initWithFrame:CGRectMake(0,0,self.view.frame.size.width,self.view.frame.size.height-106*2/6)];
    listTable.dataSource = self;
    listTable.delegate = self;
    [self.view addSubview:listTable];
    listTable.separatorStyle = UITableViewCellSeparatorStyleNone;
    [listTable release];
    
    [self getPictureList];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    return [sourceArray count];
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return [ZYPictureCell pictureCellHeight];
}
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    ZYPictureCell *cell = (ZYPictureCell*)[tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    // Configure the cell...
    if (!cell) {
        cell = [[[ZYPictureCell alloc]initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier withTapOnCell:^(NSInteger itemIndex) {
        
            NSDictionary *item = [[sourceArray objectAtIndex:indexPath.row]objectAtIndex:itemIndex];
            
            ZYPicturePreViewController *preVC = [[ZYPicturePreViewController alloc]initWithImageString:[item objectForKey:@"images"] withSummaryText:[item objectForKey:@"summary"]];
            preVC.mainTitle = @"图片详情";
            [ZYMobCMSUitil setBFNNavItemForReturn:preVC];
            [self.navigationController pushViewController:preVC animated:YES];
            [preVC release];
            
            
        }]autorelease];
    }
    [cell setContentArray:[sourceArray objectAtIndex:indexPath.row]];
    
    return cell;
}

- (void)getPictureList
{
    NSMutableDictionary *params = [NSMutableDictionary dictionary];
    [params setObject:[NSNumber numberWithInt:PageSize]  forKey:@"pageSize"];
    [params setObject:[NSNumber  numberWithInt:pageIndex] forKey:@"pageIndex"];
    
    [[BFNetWorkHelper shareHelper]requestDataWithApplicationType:ZYCMSRequestTypePictureList withParams:params withHelperDelegate:self withSuccessRequestMethod:@"getPictureListSuccess:" withFaildRequestMethod:@"getPictureListFaild:"];
}

- (void)getPictureListSuccess:(NSDictionary*)resultDict
{
    BOOL status = [[resultDict objectForKey:@"status"]boolValue];
    if (status) {
        
        NSArray *resultArray = [resultDict objectForKey:@"data"];
        NSLog(@"resultArray ___%@",resultArray);
        
        for (int i=0; i<resultArray.count; i++) {
            
            if (i%2==0&&i!=0) {
                
                NSArray *subArray = [resultArray subarrayWithRange:NSMakeRange(i-2,2)];
                
                [sourceArray addObject:subArray];
            }
        }
        if (resultArray.count%2==1) {
            NSArray *subArray = [resultArray subarrayWithRange:NSMakeRange(resultArray.count-2,1)];
            [sourceArray addObject:subArray];
        }
        
        [listTable reloadData];
        
    }
    
}

- (void)getPictureListFaild:(NSDictionary*)resultDict
{
    
}



@end