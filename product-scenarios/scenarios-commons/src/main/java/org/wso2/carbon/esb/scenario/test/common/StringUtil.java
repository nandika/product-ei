/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.esb.scenario.test.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains various string utility methods
 */
public class StringUtil {

    /**
     * Function to trim white spaces, tabs, new lines in between xml tags
     *
     * @param xmlString - The xml String to trim white spaces, tabs and new lines
     * @return - the xml string without white spaces, tabs and new lines
     */

    public static String trimTabsSpaceNewLinesBetweenXMLTags(String xmlString){

        return xmlString.replaceAll("(?!>\\s+</)(>\\s+<)", "><")
                        .replaceAll("(?!>\\t+</)(>\\t+<)", "><")
                        .replaceAll("(?!> </)(> <)", "><")
                        .replaceAll("(?!>\\n+</)(>\\n+<)", "><");

    }

    /**
     * Function to trim white spaces, tabs and new lines between json objects
     *
     * @param jsonString - The json String to trim white spaces, tabs and new lines
     * @return - the json string without white spaces, tabs and new lines
     */

    public static String trimTabsSpaceNewLinesBetweenJsonTags(String jsonString) {
        return jsonString.replaceAll(" ", "")
                         .replaceAll("\\n", "")
                         .replaceAll("\\t", "");
    }

    /**
     * Function to pattern match with regular expressions for stock quote response
     *
     * @param stockQuote - stockQuoteResponse as a String
     * @param symbol - stock quote symbol
     * @param companyName - company name of the stock quote response
     * @return - boolean if pattern matches with stock quote
     */
    public static boolean stockQuoteRegexMatch(String stockQuote, String symbol, String companyName) {
        String regex = ".*marketCap\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"symbol\":" + "\"" + symbol + "\"" +
                       ",\"last\":" + ScenarioConstants.REGEX_EXPONENT +
                       ".*percentageChange\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"change\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"prevClose\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"volume\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"earnings\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"high\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"peRatio\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"low\":" + ScenarioConstants.REGEX_EXPONENT +
                       ",\"name\":" + "\"" + companyName + "\"" +
                       ".*open\":" + ScenarioConstants.REGEX_EXPONENT + "}";

        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(stockQuote);
        return matcher.find();
    }
}
