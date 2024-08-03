package org.mypractice.debug.ds;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    private char id;
    @EqualsAndHashCode.Exclude private Node parent;

    public static Node valueOf(char a) {
        return new Node(a, null);
    }
}
