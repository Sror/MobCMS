//
//  ZYMenuItemModel.h
//  ZYMobMall
//
//  Created by barfoo2 on 13-8-27.
//  Copyright (c) 2013年 ZYProSoft. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ZYMenuItemModel : ZYBaseModel
@property (nonatomic,retain)NSString *moduleId;
@property (nonatomic,retain)NSString *index;
@property (nonatomic,retain)NSString *name;

- (id)initWithContentDict:(NSDictionary*)contentDict;

@end
