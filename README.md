# TermQRCode

TermQRCode is a wrapper to the ZXing Java library that allows you to easily create QR Codes in your terminal.

## Getting Started
### Gradle
```gradle
repositories {
  maven { url "https://jitpack.io" }
}

dependencies {
  compile 'com.github.sorleone:TermQRCode:1.0'
}
```
### Basic Usage
```Java
import com.google.zxing.WriterException;
import term.TermQRCode;

public class Main {
  public static void main(String args[]) throws WriterException {
    TermQRCode termQRCode = new TermQRCode();
    System.out.println(termQRCode.generate("test"));
  }
}
```
### Contribution
Please report issues/bugs, feature requests and suggestions for improvements to the <a href="https://github.com/sorleone/TermQRCode/issues">issue tracker</a>.
