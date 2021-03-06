//
//  ZYUserManager.h
//  ZYMobCMS
//
//  Created by ZYVincent on 13-8-10.
//  Copyright (c) 2013年 ZYVincent. All rights reserved.
//

#import <Foundation/Foundation.h>

#define ZY_USER_UDF @"ZY_USER_UDF"
#define ZY_USER_ACTIVE_OPEN_UDF @"user_active_open"

@interface ZYUserManager : NSObject

+ (NSString*)getCurrentUserId;

+ (NSString*)getCurrentUserLoginName;

+ (BOOL)loginOutThisUserById:(NSString*)userId;

+ (BOOL)loginOutThisUserByLoginName:(NSString*)loginName;

+ (BOOL)loginThisUserById:(NSString*)userId;

+ (BOOL)loginThisUserByLoginName:(NSString*)loginName;

+ (void)saveLoginUser:(NSDictionary*)userDict;

+ (void)saveLoginUser:(NSDictionary *)userDict loginState:(BOOL)state;

+ (NSDictionary*)getUserDictWithLoginName:(NSString*)loginName;
+ (NSDictionary*)getUserDictWithUserId:(NSString*)userId;
+ (NSDictionary*)getCurrentUserDict;

+ (void)loginOutUserWithUserName:(NSString*)loginName;

+ (NSString*)getCurrentUserLoginNameById:(NSString*)userId;

+ (BOOL)userIsLogined;

+ (void)loginOutCurrentUser;

+ (void)changeUserActiveOpenState:(BOOL)state;

+ (BOOL)getUserActiveRecordState;

@end
