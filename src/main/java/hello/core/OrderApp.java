package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.orderService;
import hello.core.order.orderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService=appConfig.memberService();
//        orderService orderService = appConfig.orderService();
        ApplicationContext cs=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = cs.getBean("memberService", MemberServiceImpl.class);
        orderServiceImpl orderService = cs.getBean("orderService", orderServiceImpl.class);
        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order item = orderService.createOrder(memberId, "ItemA", 20000);
        System.out.println(item);


    }
}