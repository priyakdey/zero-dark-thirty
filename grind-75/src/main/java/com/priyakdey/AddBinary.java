package com.priyakdey;


public class AddBinary {

    public String addBinary(String a, String b) {
        int curr1 = a.length() - 1, curr2 = b.length() - 1;
        char carry = '0';
        StringBuilder buf = new StringBuilder();

        while (curr1 >= 0 && curr2 >= 0) {
            char x = a.charAt(curr1);
            char y = b.charAt(curr2);
            Pair pair = add(x, y, carry);
            carry = pair.carry;
            buf.append(pair.sum);
            curr1--;
            curr2--;
        }

        while (curr1 >= 0) {
            char x = a.charAt(curr1);
            Pair pair = add(x, '0', carry);
            carry = pair.carry;
            buf.append(pair.sum);
            curr1--;
        }

        while (curr2 >= 0) {
            char y = b.charAt(curr2);
            Pair pair = add('0', y, carry);
            carry = pair.carry;
            buf.append(pair.sum);
            curr2--;
        }

        if (carry == '1') {
            buf.append(carry);
        }

        return buf.reverse().toString();
    }

    private Pair add(char x, char y, char carry) {
        if (x == '0' && y == '0' && carry == '0') return new Pair('0', '0');
        if (x == '0' && y == '0' && carry == '1') return new Pair('1', '0');
        if (x == '0' && y == '1' && carry == '0') return new Pair('1', '0');
        if (x == '0' && y == '1' && carry == '1') return new Pair('0', '1');
        if (x == '1' && y == '0' && carry == '0') return new Pair('1', '0');
        if (x == '1' && y == '0' && carry == '1') return new Pair('0', '1');
        if (x == '1' && y == '1' && carry == '0') return new Pair('1', '0');
        if (x == '1' && y == '1' && carry == '1') return new Pair('1', '1');

        throw new IllegalArgumentException("invalid arguments");
    }

    private record Pair(char sum, char carry) {
    }

}
