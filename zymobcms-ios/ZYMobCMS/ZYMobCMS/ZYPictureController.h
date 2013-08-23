//
//  ZYPictureController.h
//  ZYMobCMS
//
//  Created by ZYVincent on 13-8-10.
//  Copyright (c) 2013年 ZYVincent. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "BFNBaseViewController.h"
#import "ZYPictureCell.h"

@interface ZYPictureController : BFNBaseViewController<UITableViewDelegate,UITableViewDataSource,EGORefreshTableHeaderDelegate>
{
    EGORefreshTableHeaderView *_refreshHeaderView;
    BOOL _isLoadMore;
    BOOL _reloading;
    
    UITableView *listTable;
    
    NSMutableArray *sourceArray;
    NSMutableArray *tabTypeArray;
    NSInteger      pageIndex;
    BOOL            hideLoadMore;
    
}
@property (nonatomic,retain)NSString *categoryId;
@property (nonatomic,retain)NSString *currentTabType;
@property (nonatomic,assign)NSInteger      pageIndex;

- (void)getPictureList;
- (void)getAllTabTypes;
@end
