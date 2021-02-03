create table transfer_water(
	id  bigint not null PRIMARY KEY AUTO_INCREMENT comment '账号流水ID',
	phone varchar(11) not null comment '商家手机号',
	wMoney int(10) not null default 0 comment '转账金额',
	bankName varchar(100) comment '银行名称',
	bankNo   varchar(30)  comment '银行卡号',
	bankPerson varchar(20) comment '持卡人姓名',
	state tinyint default 0 comment '状态',
	aDes  varchar(100) comment '原因描述',
    sTime datetime  comment '提交时间',
    cTime datetime comment '审核时间',
    index sjid_inx(phone)
)engine=innodb AUTO_INCREMENT=10000 charset=utf8

create table shensu(
	id bigint not null primary key AUTO_INCREMENT comment '申诉ID',
	stId varchar(30) not null comment '子任务号',
	ssPhone varchar(11) not null comment '发起方',
	aPhone varchar(11) not null comment '接受方',
	builder tinyint not null comment '发起申诉者标识,1:商家发起,2:买手发起',
	title varchar(100) not null comment '申诉标题',
 	state tinyint default 0 comment '状态 1:申诉中,0:申诉关闭,-1:申诉取消',
 	isIn tinyint default 0 comment '平台介入 1:平台价入,0:平台没有介入',
 	ask  varchar(100) comment '申诉要求',
 	image LONGTEXT comment '申诉附图',
 	sjPhone varchar(11) comment '商家手机号',
 	bPhone  varchar(11) comment '买手手机号',
 	taobaoVip varchar(100) comment '接单账号',
 	oId   varchar(30) comment '订单号',
 	shopName varchar(100) comment '店铺名',
 	ssTime datetime comment '申诉时间',
 	chuLi  varchar(30) comment '平台处理人',
 	chuLiTime varchar(20) comment '平台处理时间',
 	chuLiRes varchar(300) comment '平台处理结果',
 	
 	index su_inx(ssPhone),
 	index a_inx(aPhone),
 	index sjp_inx(sjPhone),
 	index bp_inx(bPhone),
 	index tbv_inx(taobaoVip),
 	index sn_inx(shopName),
 	index st_inx(stId)
)engine=innodb AUTO_INCREMENT=10000 charset=utf8


create table message(
	id bigint not null primary key AUTO_INCREMENT comment '消息ID',
	senderPhone varchar(11) not null ,
	receiverPhone varchar(11) not null,
	context  LONGTEXT comment '消息内容',
	stId varchar(30) comment '子任务编号',
	taobaoVip varchar(100) comment '买手账号',
	wangWang varchar(100) comment '买手旺旺号',
	cTime varchar(15) comment '时间',
	builder int not null comment '消息发起者,1:商家,2:买手',
	
	index sender_inx(senderPhone),
	index receiver_inx(receiverPhone),
	index stId_inx(stId),
	index taobaovip_inx(taobaovip),
	index ww_inx(wangWang)
)engine=innodb AUTO_INCREMENT=10000 charset=utf8

create table sysmessage(
	id bigint not null primary key AUTO_INCREMENT comment '管理员消息ID',
	title varchar(30) not null comment '标题',
	context LONGTEXT not null  comment '内容',
	phone varchar(11) not null comment '商家手机号',
	cTime datetime not null comment '时间',
	index sj_p_inx(phone)
)engine=innodb AUTO_INCREMENT=10000 charset=utf8

create table account_water(
	id bigint not null primary key AUTO_INCREMENT comment '流水ID',
	phone varchar(11) not null comment '商家手机号',
	category tinyint comment '类型',
	info varchar(300) comment '详情',
	cMoney int(8) not null comment '变动额',
	rMoney int(8) not null comment '余额',
	tTime datetime comment '交易时间',
	index sjid_inx(phone) 
)engine=innodb AUTO_INCREMENT=10000 charset=utf8

create table shop(
	id bigint not null primary key AUTO_INCREMENT comment '店铺ID',
	phone varchar(11) not null comment '商家ID',
	name varchar(100) comment '店铺名称',
	wangWang varchar(30) comment '店铺旺旺',
	state tinyint default 0 comment '状态',
	sDesc varchar(100) comment '原因描述',
	sWhere varchar(300) comment '商品发货地',
	address varchar(300) comment '详细地址',
	sPhone varchar(11) comment '发货电话',
	image MediumBlob comment '店铺后台截图',
	platform varchar(30) comment '平台',
	sTime datetime comment '创建时间',
	index sjid_inx_s(phone),
	index name_inx_s(name),
	index sjid_state_s(phone,state)
)engine=innodb AUTO_INCREMENT=10000 charset=utf8

create table orders(
	id varchar(30) not null primary key comment '子任务编号',
	platform varchar(30) not null comment '平台',
	taobaoVip varchar(100) comment '接单账号',
	oid varchar(30) comment '订单号',
	tid varchar(30)  not null comment '主任务号',
	sjPhone varchar(11) not null comment '商家手机号',
	bPhone varchar(11) not null comment '买手手机号',
	image LONGTEXT not null comment '任务主图',
	yaJin  int(8) comment '返款押金',
	sMoney int(8) comment '提交金额',
	yongJin int(8) comment '服务费(佣金)',
	state tinyint comment '子任务状态',
	cTime datetime comment '接单时间',
	sTime datetime comment '提交时间',
	rTime dateTime comment '奖励核实时间',
	goodsName varchar(100) comment '商品名称',
	shopName varchar(100) comment '店铺名称',
	tType  int comment "任务类型",
	index tbv_inx_o(taobaovip),
	index gn_inx_o(goodsname),
	index oid_inx_o(oId),
	index sn_inx_o(shopname),
	index sj_p_inx_o(sjPhone),
	index b_p_in_o(bPhone)
)engine=innodb  charset=utf8


create table tasks(
	id varchar(30) not null primary key comment '任务编号',
	goodsInfos LONGTEXT not null comment "商品信息",
	souSuo LONGTEXT not null comment '关键字或淘口令',
	findGoods LONGTEXT comment '查询商品信息',
	pingJia LONGTEXT comment '评价',
    zengZhi LONGTEXT comment '增值服务',
    pushTime LONGTEXT comment '发布时间',
    liuYan varchar(300) comment '商家留言',
    shenHe varchar(300) comment '商品核实连接',
    fanKuan int comment '返款方式,1:平台系统返款+买号安全',
    totalCost double comment '总费用',
    serviceCost double comment '服务费',
    phone varchar(11) comment '商家手机号',
    state int comment '任务状态',
    getState int comment '领取状态,1:已领取完0:未领取完',
    shopName varchar(100) comment '店铺名',
    goodsName varchar(100) comment '商品名',
    taskType int comment '任务类型',
    cTime datetime comment '任务创建时间',
    sTime datetime comment '审核时间',
    tTime datetime comment '发布时间',
    shenHer varchar(100) comment '审核操作人',
    orderCount int comment '已接单数',
    index sj_phone_inx(phone)
)engine=innodb  charset=utf8



create table notice(
	id bigint not null primary key AUTO_INCREMENT comment '商家公告ID',
	title varchar(100) comment '标题',
	context text comment '公告内容',
	state tinyint comment '是否重要,1:重要,0:普通',
	cTime varchar(20) comment '公告时间'
	
	
)engine=innodb AUTO_INCREMENT=10000 charset=utf8

create table buyer(
	id bigint not null primary key comment '买手ID',
	phone varchar(11) not null  comment '买手手机号',
	weiXin varchar(30) not null comment '买手微信号',
	taobaoVip varchar(100) not null comment '买手淘宝会员号',
	pwd varchar(11) not null comment '密码',
	sex tinyint not null comment '性别 1:男,0:女',
	superCode varchar(6) not null comment '上级邀请码',
	branchNo  varchar(30) not null comment '所属分站',
	cTime datetime not null comment '注册时间',
	msgCount int comment '最新消息数',
	shenSuCount int comment '最新申诉数',
	index sc_inx_b(superCode),
	index b_inx_b(branchNo),
	index p_inx_b(phone)
)engine=innodb AUTO_INCREMENT=100100 charset=utf8

create table shangJia(
	id bigint not null primary key comment '商家ID',
	phone varchar(11) not null  comment '商家手机号',
	pwd varchar(11) not null comment '密码',
	qq varchar(30) not null comment 'qq',
	selfMoney int(10) not null default 0 comment '本金余额',
	yongjinMoney int(10) not null default 0 comment '佣金余额',
	zengzhiMoney int(10) not null default 0 comment '增值服务费余额',
	yaoqingMoney int(10) not null default 0 comment '邀请收益余额',
	superCode varchar(6)  not null comment '上级邀请码',
	branchNo varchar(30) not null comment '所属分站',
	sCheck tinyint not null comment '是否免审状态',
	cTime datetime not null comment '注册时间',
	msgCount int comment '最新消息数',
	shenSuCount int comment '最新申诉数',
	index sc_inx_sj(superCode),
	index b_inx_sj(branchNo),
	index p_inx_sj(phone)
)engine=innodb AUTO_INCREMENT=100100 charset=utf8

create table serviceCost(
	sCost varchar(10) not null comment '商品最底价格',
	eCost varchar(10) not null comment '商品最高价格',
	cost int not null comment '服务费',
	index s_e_inx(sCost,eCost)
)engine=innodb charset=utf8


create table serviceCost(
	name varchar(30) not null comment '收费服务目录',
	cost varchar(1000) not null comment  '服务费用'
)engine=innodb charset=utf8

create table workOrder(
	id bigint  not null primary key comment '编号',
	bphone varchar(11) not null comment '买手手机号',
	weiXinQun varchar(30) not null comment '微信群名',
	wenTiDes varchar(1000) not null comment '问题描述',
	huiFu varchar(1000) not null comment '问题回复',
	img LONGTEXT comment '问题图片',
	cTime varchar(30) comment '工单生成时间',
	shTime varchar(30) comment '审核时间',
	shenHe varchar(30) comment '审核人',
	index bp_inx(bphone)
)engine=innodb charset=urt8