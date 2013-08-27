//
//  ZYTabTypeModel.h
//  ZYMobMall
//
//  Created by barfoo2 on 13-8-27.
//  Copyright (c) 2013年 ZYProSoft. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ZYTabTypeModel : ZYBaseModel
@property (nonatomic,retain)NSString *tabTypeId;
@property (nonatomic,retain)NSString *name;

- (id)initWithContentDict:(NSDictionary*)contentDict;

@end
