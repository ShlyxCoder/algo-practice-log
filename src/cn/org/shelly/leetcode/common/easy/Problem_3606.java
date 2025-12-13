package cn.org.shelly.leetcode.common.easy;

import java.util.*;
import java.util.regex.Pattern;

public class Problem_3606 {

    class Solution {

        private static final Pattern CODE_PATTERN =
                Pattern.compile("^[a-zA-Z0-9_]+$");

        private static final List<String> BUSINESS_ORDER =
                Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

        public List<String> validateCoupons(String[] code,
                                            String[] businessLine,
                                            boolean[] isActive) {
            Map<String, List<String>> map = new HashMap<>();
            for (String b : BUSINESS_ORDER) {
                map.put(b, new ArrayList<>());
            }
            for (int i = 0; i < code.length; i++) {
                if (!isActive[i]) {
                    continue;
                }
                if (code[i] == null || code[i].isEmpty()) {
                    continue;
                }
                if (!CODE_PATTERN.matcher(code[i]).matches()) {
                    continue;
                }
                if (!map.containsKey(businessLine[i])) {
                    continue;
                }

                map.get(businessLine[i]).add(code[i]);
            }

            List<String> result = new ArrayList<>();

            for (String b : BUSINESS_ORDER) {
                List<String> codes = map.get(b);

                Collections.sort(codes);
                result.addAll(codes);
            }

            return result;
        }
    }

}
