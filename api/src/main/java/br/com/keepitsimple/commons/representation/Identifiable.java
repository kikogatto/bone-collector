package br.com.keepitsimple.commons.representation;

/**
 * Describes the behavior of classes that can be uniquely identified
 * @author Kiko Gatto [06/05/2015]
 *
 */
public interface Identifiable {
    /**
     * Returns the unique identity for this Identifiable
     * @return
     */
    Long getUid();
}
