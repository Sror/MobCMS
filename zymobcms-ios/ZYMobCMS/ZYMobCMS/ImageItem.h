//
//  ImageItem.h
//  ZYMobCMS
//
//  Created by ZYVincent on 13-8-3.
//  Copyright (c) 2013年 ZYVincent. All rights reserved.
//

#import <UIKit/UIKit.h>


typedef void (^tapOnImageItem) (NSString *productId);

@interface ImageItem : UIControl
{
    tapOnImageItem _tapAction;
}
@property (nonatomic,retain)UILabel *titleLabel;
@property (nonatomic,retain)UIImageView *contentImageView;
@property (nonatomic,retain)NSMutableArray *productArray;

- (id)initWithFrame:(CGRect)frame withTapAction:(tapOnImageItem)tapAction;

- (void)setItemContent:(NSDictionary*)contentDict;

@end