//
//  ZYProductCell.h
//  ZYMobCMS
//
//  Created by ZYVincent on 13-8-11.
//  Copyright (c) 2013年 ZYVincent. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "BFAttributedView.h"

@interface ZYProductCell : UITableViewCell
{
    UIImageView *backImageView;
    
    UIImageView *conentImageView;
    BFAttributedView *titleView;
    BFAttributedView *summaryView;
    BFAttributedView *priceView;
    UIImageView *favTagImageView;
    BFAttributedView *favCountView;
}

- (void)setProductInfo:(NSDictionary*)productDict;

+ (CGFloat)heightForProductCell;

@end
