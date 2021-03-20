[![](https://jitpack.io/v/haerulmuttaqin/BottomFluxDialog.svg)](https://jitpack.io/#haerulmuttaqin/BottomFluxDialog)

Bottom Flux Dialog
===================
BottomFluxDialog, Simple way make your beautiful dialog

[Demo Download](https://github.com/haerulmuttaqin/BottomFluxDialog/blob/master/app-release.apk)

## ScreenShot
![image](https://github.com/haerulmuttaqin/BottomFluxDialog/blob/master/bottom-flux-ss.png)

## Setup
The simplest way to use BottomFluxDialog is to add the library as aar dependency to your build.

**Maven**

    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

    <dependency>
        <groupId>com.github.haerulmuttaqin</groupId>
        <artifactId>BottomFluxDialog</artifactId>
        <version>0.1.0</version>
    </dependency>

**Gradle**

    repositories {
        maven { url 'https://jitpack.io' }
    }

    dependencies {
            implementation 'com.github.haerulmuttaqin:BottomFluxDialog:0.1.0'
    }

## Usage

**display dialogs easily**

Info dialog：

    BottomFluxDialog.infoDialog(MainActivity.this)
            .setTextTitle("Info Title")
            .setTextMessage("This is a info message")
            .setImageDialog(R.drawable.ic_dialog_info)
            .setInfoButtonText("CLOSE")
            .show();

Alert dialog：

    BottomFluxDialog.alertDialog(MainActivity.this)
            .setTextTitle("Alert Title")
            .setTextMessage("This is a alert message")
            .setImageDialog(R.drawable.ic_dialog_alert)
            .setAlertButtonText("OK")
            .setAlertListener(new BottomFluxDialog.OnAlertListener() {
                @Override
                public void onClick() {
                    Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
                }
            })
            .show();

Confirm dialog：

    BottomFluxDialog.confirmDialog(MainActivity.this)
            .setTextTitle("Confirm Title")
            .setTextMessage("This is a confirm message")
            .setImageDialog(R.drawable.ic_dialog_confirm)
            .setLeftButtonText("CANCEL")
            .setRightButtonText("OK")
            .setConfirmListener(new BottomFluxDialog.OnConfirmListener() {
                @Override
                public void onLeftClick() {
                    Toast.makeText(MainActivity.this, "Left Button Clicked!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onRightClick() {
                    Toast.makeText(MainActivity.this, "Right Button Clicked!", Toast.LENGTH_SHORT).show();
                }
            })
            .show();
            
Input dialog:

    BottomFluxDialog.inputDialog(MainActivity.this)
                            .setTextTitle("Input Title")
                            .setTextMessage("This is a input message")
                            .setRightButtonText("SUBMIT")
                            .setInputListener(new BottomFluxDialog.OnInputListener() {
                                @Override
                                public void onSubmitInput(String text) {
                                    Toast.makeText(MainActivity.this, "Input : " + text, Toast.LENGTH_SHORT).show();
                                }
    
                                @Override
                                public void onCancelInput() {
                                    Toast.makeText(MainActivity.this, "Button Cancel Clicked!", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();

## License

    MIT License
    
    Copyright (c) 2020 Haerul Muttaqin
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.


