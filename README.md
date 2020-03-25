### aop术语

1. 通知-advice

定义了切面是什么以及何时使用

* 前置通知：目标方法调用之前
* 后置通知：目标方法完成之后，不关心方法的输出
* 返回通知：目标方法成功执行之后
* 异常通知：抛出异常之后
* 环绕通知：通知包裹了被通知的方法，在被通知的方法调用前后执行自定义的行为

2. 连接点-join point

连接点是在应用执行过程中能够插入切面的一个点。

3. 切点-pointcut

切点定义了切面在何处使用，切点会匹配通知所要织入的一个或多个连接点。

4. 切面-aspect

通知+切点

5. 引入-introduction

引入允许我们向现有的类添加新方法和属性

6. 织入-weaving

织入是把切面应用到目标对象并创建新的代理对象的过程。
在目标对象的生命周期里有多个点可以开始织入：

* 编译期
* 类加载期
* 运行期 - spring aop采用这种方式

### spring aop的支持
1. 基于代理的经典spring aop
2. 纯pojo切面
3. @AspectJ注解驱动的切面
4. 注入式AspectJ切面

spring aop构建在动态代理基础之上，局限于方法拦截

```
通过在代理类中包裹切面，spring在运行期间把切面织入到spring管理的bean中。
代理类封装了目标类，并拦截被通知方法的调用，再把调用转发给真正的目标类，调用目标bean方法之前，会执行切面逻辑。
```
spring只支持方法级别的连接点

### 编写切点，通知，切面

切点
```
package concert;
public interface Performance {
    public void perform();
}
// * : 表示返回任意类型 
execution(* cocert.Performance.perform(..))
```
注解编写切面
```
1. 编写切面

2. 启动@AspectJ注解的自动代理

```
Code Ref:

[Spring AOP Learning](https://github.com/edwardqi/spring-aop-learning)