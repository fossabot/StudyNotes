--分页查询商品列表
select * from goodstable limit ?,?;
--查询所有商品信息
select * from goodstable;
--查询商品的总记录数
select count(0) from goodstable;
--向商品表中插入记录
insert into goodstable (name,gtid,price,stock,remarks) values(?,?,?,?,?);
--删除商品信息
delete from goodstable where id = ?
--商品详情查询
select g.id,g.name,g.gtid,gt.name as gtname,price,stock,remarks from goodstable g inner join goodstype gt on g.gtid=gt.id where g.id = ?
--修改商品信息
update goodstable set name=?,gtid=?,price=?,stock=?,remarks=? where id=?
--查询所有商品类别
select * from goodstype; 
--登陆验证
select * from usertable where name = ? and password = ?;
