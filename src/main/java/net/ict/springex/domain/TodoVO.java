package net.ict.springex.domain;

/*MyBaits 와 스프링을 이용한 영속처리
*1. vo 선언
* 2. Mapper 인테페이스 개발
* 3.xml개발
* 4.테스트코드 개발
*/

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private  boolean finished;
    private String writer; //작성자
}
