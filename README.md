## Demo
![](https://github.com/istarvip/AndroidLoading/blob/master/Demo.gif)

## 使用 

### Step 1

添加jar包在libs里
* `nineoldandroids-2.4.0.jar`
* ` 导入AndroidLoading库到项目中` 

### Step 2

添加LoadingIndicatorView 到用的布局文件中:
```java
    <cn.istarvip.loading.LoadingIndicatorView  
		    android:id="@+id/loading_icon"
		    android:layout_centerInParent="true" 
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" 
                        app:indicator="BallSpinFadeLoader"
          />
```

### Step 3

控制加载进程
```java
   void startAnim(){
        findViewById(R.id.loading_icon).setVisibility(View.VISIBLE);
   }
   
   void stopAnim(){
        findViewById(R.id.loading_icon).setVisibility(View.GONE);
   }
   
```
## Indicators

  indicators 在以下中任选:

**Row 1**
 * `BallPulse`
 * `BallGridPulse`
 * `BallClipRotate`
 * `BallClipRotatePulse`

**Row 2**
 * `SquareSpin`
 * `BallClipRotateMultiple`
 * `BallPulseRise`
 * `BallRotate`

**Row 3**
 * `CubeTransition`
 * `BallZigZag`
 * `BallZigZagDeflect`
 * `BallTrianglePath`

**Row 4**
 * `BallScale`
 * `LineScale`
 * `LineScaleParty`
 * `BallScaleMultiple`

**Row 5**
 * `BallPulseSync`
 * `BallBeat`
 * `LineScalePulseOut`
 * `LineScalePulseOutRapid`

**Row 6**
 * `BallScaleRipple`
 * `BallScaleRippleMultiple`
 * `BallSpinFadeLoader`
 * `LineSpinFadeLoader`

**Row 7**
 * `TriangleSkewSpin`
 * `Pacman`
 * `BallGridBeat`
 * `SemiCircleSpin`