//
//  ZYMyCommentCell.m
//  ZYMobCMS
//
//  Created by ZYVincent on 13-8-17.
//  Copyright (c) 2013年 ZYVincent. All rights reserved.
//

#import "ZYMyCommentCell.h"

@implementation ZYMyCommentCell

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
    }
    return self;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect
{
    // Drawing code
}
*/

- (void)setContentDict:(NSDictionary *)contentDict
{
//    NSString *title = [contentDict objectForKey:@"login_name"];
    NSString *articleTitle = [contentDict objectForKey:@"title"];
    NSString *content = [contentDict objectForKey:@"content"];
    NSString *date = [contentDict objectForKey:@"create_time"];
    date = [NSString stringWithFormat:@"发表于 %@",[BFUitils intervalSinceNow:date]];

    
//    [titleView setContentText:title];
    [dateView setText:date];
    [contentView setContentText:content];
    [articleTitleView setContentText:articleTitle];
    
    CGFloat originY = TopMargin;
    
    CGFloat totalWidth = self.frame.size.width-2*LeftMargin-2*LeftMargin;
    
    CGFloat articleTitleHeight = [BFAttributedView getAttributedContentHeight:articleTitleView.contentAttributedString withWdith:totalWidth];
    articleTitleView.frame = CGRectMake(LeftMargin+LeftMargin/2,originY,totalWidth,MIN(20,articleTitleHeight));
    originY = articleTitleView.frame.origin.y+articleTitleView.frame.size.height+TextMargin;

    CGFloat contentHeight = [BFAttributedView getAttributedContentHeight:contentView.contentAttributedString withWdith:totalWidth];
    contentView.frame = CGRectMake(LeftMargin+LeftMargin/2,originY,totalWidth,contentHeight);
    originY = contentView.frame.origin.y+contentView.frame.size.height+TextMargin;
    
    backImgView.frame = CGRectMake(LeftMargin,TopMargin/2,self.frame.size.width-2*LeftMargin,originY);
    originY = originY + TopMargin/2;
    
    CGSize dateSize = [date sizeWithFont:[UIFont systemFontOfSize:TitleFontSize] constrainedToSize:CGSizeMake(totalWidth/2,999999)];
    dateView.frame = CGRectMake(self.frame.size.width-2*LeftMargin-dateSize.width,originY,dateSize.width,dateSize.height);
    originY = dateView.frame.origin.y+dateView.frame.size.height + TextMargin;
    

}

+ (CGFloat)heightWithContent:(NSDictionary *)contentDict forTable:(UITableView *)table
{
//    NSString *title = [contentDict objectForKey:@"login_name"];
    NSString *articleTitle = [contentDict objectForKey:@"title"];
    NSString *content = [contentDict objectForKey:@"content"];
    NSString *date = [contentDict objectForKey:@"create_time"];
    date = [NSString stringWithFormat:@"发表于 %@",[BFUitils intervalSinceNow:date]];

    BFAttributeDescriptor *contentDes = [[BFAttributeDescriptor alloc]init];
    contentDes.fontSize = ContentFontSize;
    contentDes.lineSpace = ContentLineSpace;
    NSAttributedString *contentAtti = [BFAttributedView createAttributedString:content withDescriptor:contentDes];
    [contentDes release];
    
    BFAttributeDescriptor *articleTitleDes = [[BFAttributeDescriptor alloc]init];
    articleTitleDes.fontSize = ContentFontSize;
    articleTitleDes.lineSpace = ContentLineSpace;
    NSAttributedString *articleTitleAtti = [BFAttributedView createAttributedString:articleTitle withDescriptor:articleTitleDes];
    [articleTitleDes release];
    
    CGFloat originY = TopMargin;
    
    CGFloat totalWidth = table.frame.size.width-2*LeftMargin-LeftMargin/2;
    
    CGFloat articleTitleHeight = [BFAttributedView getAttributedContentHeight:articleTitleAtti withWdith:totalWidth];
    CGRect articleTitleRect = CGRectMake(LeftMargin+LeftMargin/2,originY,totalWidth,MIN(articleTitleHeight,20));
    originY = articleTitleRect.origin.y+articleTitleRect.size.height+TextMargin;
    
    CGFloat contentHeight = [BFAttributedView getAttributedContentHeight:contentAtti withWdith:totalWidth];
    CGRect contentRect = CGRectMake(LeftMargin+LeftMargin/2,originY,totalWidth,contentHeight);
    originY = contentRect.origin.y+contentRect.size.height+TextMargin;
    
    CGSize dateSize = [date sizeWithFont:[UIFont systemFontOfSize:TitleFontSize] constrainedToSize:CGSizeMake(totalWidth/2,999999)];
    CGRect dateRect = CGRectMake(table.frame.size.width-2*LeftMargin-dateSize.width,originY,dateSize.width,dateSize.height);
    originY = dateRect.origin.y+dateRect.size.height + TextMargin;
    
    return originY;

}

@end
