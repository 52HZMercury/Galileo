# 开发日志
## 24.9.20
搭好了框架 ，写了简单的登录进行验证
## 24.9.21
1. 为实现随意修改用户名，决定采用手机号码或者电子邮件作为登录id，手机号验证登录需要购买短信，暂不开发
2. 实现对用户注册的密码加密存储
参考链接：
- https://blog.csdn.net/u012888704/article/details/107406374 BCryptPasswordEncoder加密 
- https://zhuanlan.zhihu.com/p/111824045 还暂未实现redis分布式锁，后续考虑升级