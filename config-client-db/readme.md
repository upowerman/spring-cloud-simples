1. 启动 config-server-db
2. 启动 config-client-db
3. 由于时基于refreshscop 的刷新配置 所以需要在修改数据配置文件后  调用http://localhost:9096/actuator/refresh 接口来重新加载配置文件
4. 读取的数据才会发生变化
