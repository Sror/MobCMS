//
//  ZYLoginViewController.h
//  ZYMobMall
//
//  Created by barfoo2 on 13-8-27.
//  Copyright (c) 2013年 ZYProSoft. All rights reserved.
//

#import "ZYBaseViewController.h"

@interface ZYLoginViewController : UIViewController
{
    UITextField *loginNameField;
    UITextField *passwordField;
    
    ZYUserDataCenter *userCenter;
}

@end
