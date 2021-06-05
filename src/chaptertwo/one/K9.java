package chaptertwo.one;

/**
 * @author gxx
 * @create 2021-06-05 13:36
 */
public class K9 {

    public static void main(String[] args) {
        /**
         *  E   A   S   Y   S   H   E   L   L   S   O   R   T   Q   U   E   S   T   I   O   N
         *
         *  h=13
         *  e   A   S   Y   S   H   E   L   L   S   O   R   T   q   U   E   S   T   I   O   N
         *  E   a   S   Y   S   H   E   L   L   S   O   R   T   Q   u   E   S   T   I   O   N
         *  E   A   e   Y   S   H   E   L   L   S   O   R   T   Q   U   s   S   T   I   O   N
         *  E   A   E   s   S   H   E   L   L   S   O   R   T   Q   U   S   y   T   I   O   N
         *  E   A   E   S   s   H   E   L   L   S   O   R   T   Q   U   S   Y   t   I   O   N
         *  E   A   E   S   S   h   E   L   L   S   O   R   T   Q   U   S   Y   T   i   O   N
         *  E   A   E   S   S   H   e   L   L   S   O   R   T   Q   U   S   Y   T   I   o   N
         *  E   A   E   S   S   H   E   l   L   S   O   R   T   Q   U   S   Y   T   I   O   n
         *
         *  h=4
         *  e   A   E   S   s   H   E   L   L   S   O   R   T   Q   U   S   Y   T   I   O   N
         *  E   a   E   S   S   h   E   L   L   S   O   R   T   Q   U   S   Y   T   I   O   N
         *  E   A   e   S   S   H   e   L   L   S   O   R   T   Q   U   S   Y   T   I   O   N
         *  E   A   E   l   S   H   E   s   L   S   O   R   T   Q   U   S   Y   T   I   O   N
         *  e   A   E   L   l   H   E   S   s   S   O   R   T   Q   U   S   Y   T   I   O   N
         *  E   a   E   L   L   h   E   S   S   s   O   R   T   Q   U   S   Y   T   I   O   N
         *  E   A   e   L   L   H   e   S   S   S   o   R   T   Q   U   S   Y   T   I   O   N
         *  E   A   E   l   L   H   E   r   S   S   O   s   T   Q   U   S   Y   T   I   O   N
         *  e   A   E   L   l   H   E   R   s   S   O   S   t   Q   U   S   Y   T   I   O   N
         *  E   a   E   L   L   h   E   R   S   q   O   S   T   s   U   S   Y   T   I   O   N
         *  E   A   e   L   L   H   e   R   S   Q   o   S   T   S   u   S   Y   T   I   O   N
         *  E   A   E   l   L   H   E   r   S   Q   O   s   T   S   U   s   Y   T   I   O   N
         *  e   A   E   L   l   H   E   R   s   Q   O   S   t   S   U   S   y   T   I   O   N
         *  E   a   E   L   L   h   E   R   S   q   O   S   T   t   U   S   Y   s   I   O   N
         *  E   A   e   L   L   H   e   R   S   Q   i   S   T   T   o   S   Y   S   u   O   N
         *  E   A   E   l   L   H   E   r   S   Q   I   s   T   T   O   s   Y   S   U   o   N
         *  e   A   E   L   l   H   E   R   n   Q   I   S   s   T   O   S   t   S   U   O   y
         *
         *  h=1
         *
         *  a   e   E   L   L   H   E   R   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   L   L   H   E   R   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   l   L   H   E   R   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   l   l   H   E   R   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   h   l   l   E   R   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   l   l   R   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   l   l   r   N   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   l   l   n   r   Q   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   l   l   n   q   r   I   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   q   r   S   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   q   r   s   S   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   q   r   s   s   T   O   S   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   q   r   s   s   t   O   S   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   o   q   r   s   s   t   S   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   o   q   r   s   s   s   t   T   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   o   q   r   s   s   s   t   t   S   U   O   Y
         *  a   e   e   e   h   i   l   l   n   o   q   r   s   s   s   s   t   t   U   O   Y
         *  a   e   e   e   h   i   l   l   n   o   q   r   s   s   s   s   t   t   u   O   Y
         *  a   e   e   e   h   i   l   l   n   o   o   q   r   s   s   s   s   t   t   u   Y
         *  a   e   e   e   h   i   l   l   n   o   o   q   r   s   s   s   s   t   t   u   y
         */
    }
}
