create DATABASE school;
use school
create table s
(xh char(4) not null primary key,
xm char(20) not null,
pwd char(40),
xb char(2),
csrq char(10),
jg char(10),
sjhm char(20),
yxh char(2)
);
insert into s values('1101','李明','1','男','1993-03-06','上海','13613005486','02');
insert into s values('1102','刘晓明','1','男','1992-12-08','安徽','18913457890','01');
insert into s values('1103','张颖','1','女','1993-01-05','江苏','18826490423','01');
insert into s values('1104','刘晶晶','1','女','1994-11-06','上海','13331934111','01');
insert into s values('1105','刘成刚','1','男','1991-06-07','上海','18015872567','01');
insert into s values('1106','李二丽','1','女','1993-05-04','江苏','18107620945','01');
insert into s values('1107','张晓峰','1','男','1992-08-16','浙江','13912341078','01');
insert into s values('3152','周椽聿','1','男','1997-11-14','上海','1391','01');

create table d
( yxh  char(2) not null primary key,
  mc   char(10),
  dz   char(20),
 lxdh  char(10));
insert into d values('01','计算机学院','上大东校区三号楼','65347567');
insert into d values('02','通讯学院','上大东校区二号楼','65341234');
insert into d values('03','材料学院','上大东校区四号楼','65347890');
insert into d values('04','外语学院','上大宝山校区','000000');

create table t
( gh  char(4) not null primary key,
  xm   char(10),
  pwd char(40),
  xb   char(2),
 csrq  char(10),
  xl  char(10),
  jbgz   char(10),
  yxh   char(2)
  );
insert into t values('0101','陈迪茂','1','男','1973-03-06','副教授','3567.00','01');
insert into t values('0102','马小红','1','女','1972-12-08','讲师','2845.00','01');
insert into t values('0201','张心颖','1','女','1960-01-05','教授','4200.00','02');
insert into t values('0103','吴宝钢','1','男','1980-11-06','讲师','2554.00','01');
insert into t values('0104','岳晓东','1','男','1980-11-06','副教授','100000.00','01');
insert into t values('0105','张建','1','男','1960-11-06','讲师','100000.00','01');
insert into t values('3155','戴炘恬','1','女','2016-08-13','院士','100000.00','04');

create table c
( kh  char(8) not null primary key,
  km   char(10),
  xf   char(1)default '4',
  xs  char(2)default '40',
  yxh  char(2)
  );
insert into c values('08305001','离散数学','4','40','01');
insert into c values('08305002','数据库原理','4','50','01');
insert into c values('08305003','数据结构','4','50','01');
insert into c values('08305004','系统结构','6','60','01');
insert into c values('08305005','数据挖掘','6','60','01');
insert into c values('08301001','分子物理学','4','40','03');
insert into c values('08302001','通信学','3','30','02');
insert into c values('02000007','无尽星空','3','30','04');

create table o
( xq  char(15) not null,
  kh   char(8),
  gh   char(4),
  sksj  char(10),
primary key(xq,kh,gh),
 foreign key(kh) references c(kh),
 foreign key(gh) references t(gh)
);
insert into o values('2012-2013秋季','08305001','0103','星期三5-8');
insert into o values('2012-2013冬季','08305002','0101','星期三1-4');
insert into o values('2012-2013冬季','08305002','0102','星期三1-4');
insert into o values('2012-2013冬季','08305002','0103','星期三1-4');
insert into o values('2012-2013冬季','08305003','0102','星期五5-8');
insert into o values('2013-2014秋季','08305004','0101','星期二1-4');
insert into o values('2013-2014秋季','08305001','0102','星期一5-8');
insert into o values('2013-2014冬季','08302001','0201','星期一5-8');
insert into o values('2018-2019春季','08305001','0104','星期一1-4');
insert into o values('2018-2019春季','08305001','0105','星期二1-4');
insert into o values('2018-2019春季','08305002','0104','星期二1-4');
insert into o values('2018-2019春季','08305005','0104','星期三1-4');
insert into o values('2018-2019春季','02000007','3155','星期五1-4');

create table e
( xh   char(4) not null ,
  xq   char(15) not null,
  kh   char(8)not null,
  gh  char(4)not null,
  pscj int check(pscj between 0 and 100),
  kscj int check(kscj between 0 and 100),
  zpcj int check(zpcj between 0 and 100),
  primary key(xh,xq,kh,gh),
  foreign key(xq,kh,gh) references o(xq,kh,gh)
  );
insert into e values('1101','2012-2013秋季','08305001','0103',60,60,60);
insert into e values('1102','2012-2013秋季','08305001','0103',87,87,87);
insert into e values('1102','2012-2013冬季','08305002','0101',82,82,82);
insert into e values('1103','2012-2013秋季','08305001','0103',56,56,56);
insert into e values('1103','2012-2013冬季','08305002','0102',75,75,75);
insert into e values('1103','2012-2013冬季','08305003','0102',84,84,84);
insert into e values('1104','2012-2013秋季','08305001','0103',74,74,74);
insert into e values('1104','2013-2014冬季','08302001','0201',75,82,80);
insert into e values('1106','2012-2013秋季','08305001','0103',85,85,85);
insert into e values('1106','2012-2013冬季','08305002','0103',66,66,66);
insert into e values('1107','2012-2013秋季','08305001','0103',90,90,90);
insert into e values('1107','2012-2013冬季','08305003','0102',79,79,79);
insert into e values('1107','2013-2014秋季','08305004','0101',64,56,60);
insert into e values('3152','2013-2014秋季','08305004','0101',90,90,90);
insert into e values('3152','2018-2019春季','08305001','0104',null,null,null);
insert into e values('3152','2018-2019春季','02000007','3155',null,null,null);

delimiter //
create trigger adjustScores before update on e
for each row
begin
  if new.zpcj > 100 then
    set new.zpcj=100;
  elseif new.zpcj < 0 then
    set new.zpcj=0;
  end if;
end;//
delimiter ;

delimiter //
create procedure GetScores(out avgScores decimal(8,2))
begin
 select avg(zpcj) into avgScores from e where xq="2018-2019春季";
end;//