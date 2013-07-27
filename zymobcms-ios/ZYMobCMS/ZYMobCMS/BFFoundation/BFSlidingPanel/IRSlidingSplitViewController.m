//
//  IRSlidingSplitViewController.m
//  IRSlidingSplitViewController
//
//  Created by Evadne Wu on 4/14/12.
//  Copyright (c) 2012 Iridia Productions. All rights reserved.
//

#import <UIKit/UIGestureRecognizerSubclass.h>

#import "IRSlidingSplitViewController.h"
#import "IRSlidingSplitViewControllerSubclass.h"
#import "IRSlidingPanGestureRecognizer.h"


@implementation IRSlidingSplitViewController
@synthesize showingMasterViewController = _showingMasterViewController;
@synthesize masterViewController = _masterViewController;
@synthesize detailViewController = _detailViewController;
@synthesize panGestureRecognizer = _panGestureRecognizer;
@synthesize tapGestureRecognizer = _tapGestureRecognizer;

//check ios version
- (BOOL)isIOSOver5{
    if ([[[UIDevice currentDevice]systemVersion]floatValue] > 5.0) {
        return YES;
    }else {
        return NO;
    }
}

//need dealloc because of retain
- (void)dealloc
{
    [_masterViewController release];
    [_detailViewController release];
    [super dealloc];
}

- (void) setShowingMasterViewController:(BOOL)flag {

	[self setShowingMasterViewController:flag animated:NO completion:nil];

}

- (void) setShowingMasterViewController:(BOOL)flag animated:(BOOL)animate completion:(void(^)(BOOL didFinish))callback {

	if (self.showingMasterViewController == flag) {
	
		if (callback)
			callback(NO);
	
		return;
		
	}
	
	_showingMasterViewController = flag;
	
	NSTimeInterval duration = animate ? 0.3 : 0;
	
	[UIView animateWithDuration:duration delay:0 options:UIViewAnimationOptionBeginFromCurrentState|UIViewAnimationOptionAllowUserInteraction animations:^{

		[self layoutViews];

	} completion:^(BOOL finished) {
		
		if (callback)
			callback(finished);
		
	}];

}

- (void) setMasterViewController:(UIViewController *)newMasterViewController {

	[self setMasterViewController:newMasterViewController animated:NO completion:nil];

}

- (void) setDetailViewController:(UIViewController *)newDetailViewController {

	[self setDetailViewController:newDetailViewController animated:NO completion:nil];

}

- (void) setMasterViewController:(UIViewController *)toMasterVC animated:(BOOL)animate completion:(void(^)(BOOL didFinish))callback {

	if (_masterViewController == toMasterVC) {
		
		if (callback)
			callback(NO);
		
		return;
		
	}
	
	[self willChangeValueForKey:@"masterViewController"];
	
    if ([self isIOSOver5]) {
        [_masterViewController willMoveToParentViewController:nil];
    }else {
        //ios 5.0 以下没有 addChildViewController 而是直接添加子视图，所以没有从父视图控制器移出的方法
    }
	
	if ([_masterViewController isViewLoaded])
		[_masterViewController.view removeFromSuperview];
	
    if ([self isIOSOver5]) {
        [_masterViewController removeFromParentViewController];
        _masterViewController = [toMasterVC retain];
    }else {
        if (_masterViewController!=nil) {
            [_masterViewController release];
            _masterViewController = nil;  
        }
        _masterViewController = [toMasterVC retain];
    }
	
    if ([self isIOSOver5]) {
        if (_masterViewController) {
            
            //添加子视图控制器备用
            [self addChildViewController:_masterViewController];
            [_masterViewController didMoveToParentViewController:self];
            
        } 
    }else {
        //放在当前detailView的下面
        [self.view addSubview:_masterViewController.view];
    }
	
	
	[self didChangeValueForKey:@"masterViewController"];
	
	if (self.isViewLoaded)
		[self layoutViews];
	
	if (callback)
		callback(YES);

}

- (void) setDetailViewController:(UIViewController *)toDetailVC animated:(BOOL)animate completion:(void(^)(BOOL didFinish))callback {

	if (_detailViewController == toDetailVC) {
		
		if (callback)
			callback(NO);
		
		return;
		
	}
	
	[self willChangeValueForKey:@"detailViewController"];
	
    if ([self isIOSOver5]) {
        [_detailViewController willMoveToParentViewController:nil];
    }else {
        //ios 5.0 以下没有 addChildViewController 而是直接添加子视图，所以没有从父视图控制器移出的方法
    }
	
	
	if ([_detailViewController isViewLoaded])
		[_detailViewController.view removeFromSuperview];
	
    if ([self isIOSOver5]) {
        [_detailViewController removeFromParentViewController];
        _detailViewController = [toDetailVC retain];
    }else {
        if (_detailViewController !=nil) {
            [_detailViewController release];
            _detailViewController = nil; 
        }
        _detailViewController = [toDetailVC retain];
    }
	
    if ([self isIOSOver5]) {
        if (_detailViewController) {
            
            //添加子视图控制器备用
            [self addChildViewController:_detailViewController];
            [_detailViewController didMoveToParentViewController:self];
            
        }
    }else {
        //detailViewController 的视图在最上面
        if ([_masterViewController isViewLoaded]) {
            [self.view insertSubview:_detailViewController.view aboveSubview:_masterViewController.view];
        }
    }
	

	[self didChangeValueForKey:@"detailViewController"];
	
	if (self.isViewLoaded)
		[self layoutViews];
    
    
	
	if (callback)
		callback(YES);
	
}

- (CGRect) rectForMasterView {

	return self.view.bounds;

}

- (CGRect) rectForDetailView {

	if (self.showingMasterViewController)
		return CGRectOffset(self.view.bounds, 250.0f, 0.0f);
	
	return self.view.bounds;

}

- (CGPoint) detailViewTranslationForGestureTranslation:(CGPoint)translation {

    //不允许在master没有出现的时候向左扫动detailview
    if (!_showingMasterViewController) {
        return CGPointMake(0,0);
    }
    
	return (CGPoint){ translation.x, 0 };
	
}

- (BOOL) shouldShowMasterViewControllerWithGestureTranslation:(CGPoint)translation velocity:(CGPoint)velocity {

	if (!self.showingMasterViewController && velocity.x > 0)
		return YES;
		
	if (self.showingMasterViewController && velocity.x < 0)
		return NO;
	
	return self.showingMasterViewController;

}

- (UIPanGestureRecognizer *) panGestureRecognizer {

	if (_panGestureRecognizer)
		return _panGestureRecognizer;
	
	_panGestureRecognizer = [[IRSlidingPanGestureRecognizer alloc] initWithTarget:self action:@selector(handlePan:)];
	_panGestureRecognizer.delegate = self;
	_panGestureRecognizer.cancelsTouchesInView = YES;

	return _panGestureRecognizer;

}

- (UITapGestureRecognizer *) tapGestureRecognizer {

	if (_tapGestureRecognizer)
		return _tapGestureRecognizer;
	
	_tapGestureRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(handleTap:)];
	_tapGestureRecognizer.delegate = self;
	_tapGestureRecognizer.cancelsTouchesInView = YES;
	
	return _tapGestureRecognizer;

}

- (BOOL) gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer shouldReceiveTouch:(UITouch *)touch {
    
	UIView *detailView = self.detailViewController.view;
	CGRect detailVisibleRect = CGRectIntersection(self.view.bounds, [self.view convertRect:detailView.bounds fromView:detailView]);
	
	BOOL touchInDetailVisibleRect = !CGRectEqualToRect(detailVisibleRect, CGRectNull) &&
		CGRectContainsPoint(detailVisibleRect, [touch locationInView:self.view]);
	
	if (gestureRecognizer == _panGestureRecognizer) {
	
		if (touchInDetailVisibleRect)
			return ![[touch view] isKindOfClass:[UISlider class]];
			
		return NO;
		
	} else if (gestureRecognizer == _tapGestureRecognizer) {
		
		return self.showingMasterViewController && touchInDetailVisibleRect;
	
	}
	
	return YES;

}

- (BOOL) gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer shouldRecognizeSimultaneouslyWithGestureRecognizer:(UIGestureRecognizer *)otherGestureRecognizer {

	if (gestureRecognizer == _tapGestureRecognizer) {
		
		if ([otherGestureRecognizer.view isDescendantOfView:self.detailViewController.view])
			return NO;
		
		if (self.showingMasterViewController)
		if (gestureRecognizer.state == UIGestureRecognizerStateRecognized)
			return NO;
		
		return YES;
		
	}
	
	if (gestureRecognizer == _panGestureRecognizer) {
	
		if ([otherGestureRecognizer.view isDescendantOfView:self.masterViewController.view])
			return NO;
		
		return NO;
		
	}
	
	return YES;

}

- (BOOL) slidingPanGestureRecognizer:(IRSlidingPanGestureRecognizer *)recognizer canPreventGestureRecognizer:(UIGestureRecognizer *)otherRecognizer proposedAnswer:(BOOL)superAnswer {

	if ([otherRecognizer.view isDescendantOfView:self.masterViewController.view])
		return YES;
	
	return superAnswer;

}

- (BOOL) slidingPanGestureRecognizer:(IRSlidingPanGestureRecognizer *)recognizer canBePreventedByGestureRecognizer:(UIGestureRecognizer *)otherRecognizer proposedAnswer:(BOOL)superAnswer {
	
	if ([otherRecognizer.view isDescendantOfView:self.masterViewController.view])
		return NO;
	
	return superAnswer;

}

- (void) handlePan:(UIPanGestureRecognizer *)panGR {

	#pragma unused(panGR)

    //can't pan
//    return;
    
	switch (panGR.state) {
		
		case UIGestureRecognizerStatePossible: {
			break;
		}
		
		case UIGestureRecognizerStateBegan: {
			
			__block UIView * (^firstResponderInView)(UIView *) = [^ (UIView *view) {

				if ([view isFirstResponder])
					return view;
				
				for (UIView *aSubview in view.subviews) {
					UIView *foundFirstResponder = firstResponderInView(aSubview);
					if (foundFirstResponder)
						return foundFirstResponder;
				}
				
				return (UIView *)nil;

			} copy];
			
			[firstResponderInView(self.masterViewController.view) resignFirstResponder];
			[firstResponderInView(self.detailViewController.view) resignFirstResponder];
			
			firstResponderInView = nil;
			
			break;
			
		}
		
		case UIGestureRecognizerStateChanged: {
			
			CGRect oldDetailRect = [self rectForDetailView];
			CGPoint translation = [panGR translationInView:self.view];
			CGPoint transformedTranslation = [self detailViewTranslationForGestureTranslation:translation];
			
			self.detailViewController.view.frame = CGRectOffset(oldDetailRect, transformedTranslation.x, transformedTranslation.y);
			
			break;
			
		}
		
		case UIGestureRecognizerStateEnded: {

			CGPoint translation = [panGR translationInView:self.view];
			CGPoint velocity = [panGR velocityInView:self.view];
			
			BOOL shouldShow = [self shouldShowMasterViewControllerWithGestureTranslation:translation velocity:velocity];
			
			if (_showingMasterViewController != shouldShow) {
			
				[self willChangeValueForKey:@"showingMasterViewController"];
				_showingMasterViewController = shouldShow;
				[self didChangeValueForKey:@"showingMasterViewController"];
				
			}
			
			//	Pass through
			
		}
		
		case UIGestureRecognizerStateCancelled:
		case UIGestureRecognizerStateFailed: {

			CGRect detailRect = self.detailViewController.view.frame;
			CGRect desiredDetailRect = [self rectForDetailView];
			
			if (!CGRectEqualToRect(detailRect, desiredDetailRect)) {
			
				BOOL (^orientationsMatch)(void) = ^ {

					UIDeviceOrientation const deviceOrientation = [UIDevice currentDevice].orientation;
					UIInterfaceOrientation const interfaceOrientation = self.interfaceOrientation;
					
					return (BOOL)(deviceOrientation == (UIDeviceOrientation)interfaceOrientation);
				
				};
			
                if ([self isIOSOver5]) {
                    if (!orientationsMatch()) {
                    
                        [UIViewController attemptRotationToDeviceOrientation];
					
                        if (orientationsMatch())
                            break;
                    
                    }
                }else {
                    //5.0 以下
                    [_masterViewController shouldAutorotateToInterfaceOrientation:[[UIDevice currentDevice]orientation]];
                    [_detailViewController shouldAutorotateToInterfaceOrientation:[[UIDevice currentDevice]orientation]];
                }
				
				[UIView animateWithDuration:0.3f delay:0 options:UIViewAnimationOptionBeginFromCurrentState|UIViewAnimationOptionAllowUserInteraction animations:^{
				
					[self layoutViews];

				} completion:nil];

			}

			break;

		}
		
	}

}

- (void) handleTap:(UITapGestureRecognizer *)tapGR {

	#pragma unused(tapGR)
	
	[self setShowingMasterViewController:NO animated:YES completion:nil];
	
}

- (void) viewDidLoad {

	[super viewDidLoad];
    
	[self.view addGestureRecognizer:self.panGestureRecognizer];
	[self.view addGestureRecognizer:self.tapGestureRecognizer];

}

- (void) setView:(UIView *)view {
	
	[super setView:view];
	
	if (!view) {
	
		_panGestureRecognizer.delegate = nil;
		_panGestureRecognizer = nil;

		_tapGestureRecognizer.delegate = nil;
		_tapGestureRecognizer = nil;
	
	}

}

- (void) viewDidLayoutSubviews {

	[super viewDidLayoutSubviews];
	[self layoutViews];

}

- (void) viewWillAppear:(BOOL)animated {

	[super viewWillAppear:animated];
	[self layoutViews];

}

- (void) layoutViews {
    
	UIView *masterView = self.masterViewController.view;
	UIView *detailView = self.detailViewController.view;
    	
	if (![masterView isDescendantOfView:self.view]) {
		[self configureMasterView:masterView];
		[self.view addSubview:masterView];
	}
	
	if (![detailView isDescendantOfView:self.view]) {
		[self configureDetailView:detailView];
		[self.view addSubview:detailView];
	}
	
	masterView.frame = [self rectForMasterView];
	detailView.frame = [self rectForDetailView];
	
    //这个属性会影响阴影效果
	masterView.clipsToBounds = YES;
//	detailView.clipsToBounds = YES;
    
    
	[detailView.superview bringSubviewToFront:detailView];
	detailView.userInteractionEnabled = !self.showingMasterViewController;
	
}

- (void) configureMasterView:(UIView *)view {

	//	For subclasses
    view.frame = CGRectMake(0,20,320,480);

}

- (void) configureDetailView:(UIView *)view {

	//	For subclasses
    view.layer.shadowColor = [UIColor blackColor].CGColor;
    view.layer.shadowOpacity = 0.4;
    view.layer.shadowOffset = CGSizeMake(-12,1.0);
    view.layer.shadowRadius = 7.0f;

}

- (BOOL) childViewControllersAllowAutoRotationToInterfaceOrientation:(UIInterfaceOrientation)toOrientation {

	if (!self.masterViewController || !self.detailViewController)
		return YES;
	
	BOOL masterVCRotatable = [self.masterViewController shouldAutorotateToInterfaceOrientation:toOrientation];
	BOOL detailVCRotatable = [self.detailViewController shouldAutorotateToInterfaceOrientation:toOrientation];

	return masterVCRotatable && detailVCRotatable;
	
}

- (BOOL) isPanning {

	return (self.panGestureRecognizer.state == UIGestureRecognizerStateChanged);

}

- (BOOL) shouldAutorotate {

	return ![self isPanning];

}

- (BOOL) shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation {

	BOOL childrenRotatable = [self childViewControllersAllowAutoRotationToInterfaceOrientation:toInterfaceOrientation];

	if (childrenRotatable && [self isPanning])
		return (self.interfaceOrientation == toInterfaceOrientation);
	
	return childrenRotatable;

}

@end