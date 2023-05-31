package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    public MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature = new MethodSignature("");

        // Remove unnecessary whitespace
        signatureString = signatureString.trim();

        // Extract access modifier
        int spaceIndex = signatureString.indexOf(' ');
        if (spaceIndex != -1) {
            methodSignature.setAccessModifier(signatureString.substring(0, spaceIndex));
            signatureString = signatureString.substring(spaceIndex + 1);
        }

        // Extract return type
        spaceIndex = signatureString.indexOf(' ');
        if (spaceIndex != -1) {
            methodSignature.setReturnType(signatureString.substring(0, spaceIndex));
            signatureString = signatureString.substring(spaceIndex + 1);
        }

        // Extract method name
        spaceIndex = signatureString.indexOf('(');
        if (spaceIndex != -1) {
            methodSignature.setMethodName(signatureString.substring(0, spaceIndex));
            signatureString = signatureString.substring(spaceIndex);
        }

        // Extract arguments
        if (signatureString.startsWith("(") && signatureString.endsWith(")")) {
            String argumentsString = signatureString.substring(1, signatureString.length() - 1);
            String[] argumentTokens = argumentsString.split(",");
            List<MethodSignature.Argument> arguments = new ArrayList<>();

            for (String argumentToken : argumentTokens) {
                argumentToken = argumentToken.trim();
                int argumentSpaceIndex = argumentToken.indexOf(' ');

                if (argumentSpaceIndex != -1) {
                    String argumentType = argumentToken.substring(0, argumentSpaceIndex);
                    String argumentName = argumentToken.substring(argumentSpaceIndex + 1);
                    arguments.add(new MethodSignature.Argument(argumentType, argumentName));
                }
            }

            methodSignature.setArguments(arguments);
        }

        return methodSignature;
    }
}
