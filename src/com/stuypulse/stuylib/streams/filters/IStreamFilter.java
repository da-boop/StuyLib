package com.stuypulse.stuylib.streams.filters;

/**
 * This lets us make sub-classes that change can modify values in this way
 * 
 * @author Sam (sam.belliveau@gmail.com)
 */

public interface IStreamFilter {

    /**
     * Get next value in StreamModifier
     * 
     * @param next next input value
     * @return next modified value
     */
    double get(double next);
}