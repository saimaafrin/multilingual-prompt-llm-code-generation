public class StringQuoter {
    /**
     * Turn the given Object into a String with single quotes if it is a String; keeping the Object as-is else.
     * @param obj the input Object (e.g. "myString") 
     * @return the quoted String (e.g. "'myString'"),or the input object as-is if not a String
     */
    public Object addQuotes(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }
}