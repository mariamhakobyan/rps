package de.ebay.rps.model;

/**
 * This enum represents possible answers from human whether to continue the game or not.
 *
 * @author Mariam Hakobyan
 */
public enum YesNo implements Selectable {

    YES("Y"),
    NO("N");

    /* Human selected answer text value */
    private String answer;

    /**
     * Constructs a YesNo object based on human selection.
     *
     * @param answer  human selected answer
     */
    private YesNo(String answer) {
        this.answer = answer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return answer;
    }

    /**
     * Returns the corresponding {@link YesNo} instance based on provided human input.
     *
     * @param input     human input in text format
     * @return          corresponding YesNo object
     */
    public static YesNo fromString(String input){
        for(YesNo value : values()){
            if(String.valueOf(value.answer).equalsIgnoreCase(input)){
                return value;
            }
        }
        return null;
    }
}
