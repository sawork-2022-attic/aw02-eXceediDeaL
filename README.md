# POS in Shell

![](assets/demo.gif)

## 分层

- **cli** 用户交互命令行界面，处理用户输入，转发给biz层。
- **biz** 业务逻辑层，实现输入的正确性检查，并调用db层执行业务逻辑，返回结果给cli层。
- **db** 数据库层，提供封装后的抽象数据库访问接口，使上层不需要关系数据库实现细节，运行实现多个底层数据库提供者。

## 实现

- `a` 添加商品，重复添加只更新数量，允许添加负数表示减少商品。当减少到0时，表示移除商品。
- `p` 打印商品列表。
- `n` 或 `e` 创建新购物车。
- `c` 结账输出购物车，并清空。
- `m` 修改购物车商品数量。
- `v` 查看当前购物车。
- `r` 移除购物车中某个商品。

## 描述

The demo shows a simple POS system with command line interface. 

To run

```shell
mvn clean spring-boot:run
```

Currently, it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.7)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome. 

Please use asciinema (https://asciinema.org) to record a demo and submit the url in QQ group. 

And please elaborate your understanding in layered systems via this homework in your README.md.
