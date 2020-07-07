开始页面两个，一个主页面（initactivity），一个用户登录
主页面一个查看书籍(readbook)，一个归还/借出书本(giveorbackbook)，一个管理书本(changebook)
查看书籍有两个，一个输入条码，一个扫描二维码，一个确定按钮
	确定按钮选择显示两个页面之中一个，一个书籍不存在，一个书籍页面
		书籍不存在(nullbook)直接显示书籍不存在
		书籍页面(showbook)显示书籍名字，书籍编号，还有多少本，本人是否已借阅
借书/还书直接扫描二维码，扫描后直接跳转到页面
	页面二选一：当前已借，是否还书/当前未借，是否借书（未做）
		确定借书(givebook)后显示以借出，并显示归还日期
		还书(backbook)直接显示已还书，并放到指定的库中
管理书本选择显示两个界面中的一个
	不是管理员(nogod)：显示你不是图书馆助理
	管理员(gods)：扫描条形码，进入修改界面，修改结束确定按钮


数据库有两个表
表1是学生表 ：学号  密码  在借书籍（书籍名称）  已借本数 是否为助理（0或1）
表2是书籍表 ：条形码  名称  存放位置  书籍编码 是否已借出  归还时间

自底向上，新开一个项目，叫做gdlglibrary，每一个button都放一个文件夹

具体安排
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

//发送数据
	returncode = obj.getText().trim();
	Intent result = new Intent();
	result.putExtra("result", returncode);
	setResult(RESULT_OK,result);
//返回数据
oncreate{
code = findViewById(R.id.bt_godcode);//扫描二维码
        editText = findViewById(R.id.gods_edit);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gods.this,CaptureActivity.class);//跳转到aar包
                startActivityForResult(intent,1);//给一个requestcode
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){//判断返回的requestcode是不是我们需要的
            String code = data.getStringExtra("result");//获得扫描结果
            //设置结果显示框的显示数值
            editText.setText(code);//设置扫描结果
        }else{
            Toast.makeText(this,"没有返回信息！",Toast.LENGTH_LONG).show();//扫描了个寂寞
        }
    }