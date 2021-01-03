package cn.edu.cqvie.domain;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study implements Cloneable {
    private String math;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
