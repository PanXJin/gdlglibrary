# gdlglibrary

#### 介绍
学校图书馆的app开发，目前还在开发中

#### 日程
6.27
扫描二维码打包
6.29
制作界面、Intent连接相应的界面
6.30
调用aar包
新导入了code这个扫描模块，还没成功跨包调用数据
（暂未）onpause需要重写成摧毁

7.1
成功获得扫描数据，在最下面有参考代码
重写onpause

7.5
重新找回了这个项目

7.6
写好了sql的连接和查阅，还没进行连接activity，参考下面代码
写好了修改，但是修改的内容还没写好
    修改要在每个activity判断是否相等，如果相等就不修改
    不相等的地方要每一个都调用一个方法，gai里面调用一个带参的方法来单独修改某一个类型
    例如：gai:   public void setbookname(int num,String bookname)
    changebooks: gai.setbookname(123456789,"一剪梅");

7.7
777777777
修改了D:\app\PanX\virtual\product\12.2.0\dbhome_1\network\admin里面Oracle的IP地址
没有成功实现
考虑通过web实现
