package com.stuypulse.stuylib.containers;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CircularBuffer<T> extends AbstractCollection<T>{
    public class CircularBufferIterator<T> implements Iterator<T>{
        private CircularBuffer<T> ref;
        int start;
        int end;
        public CircularBufferIterator(CircularBuffer<T> buf){
            ref = buf;
            start = ref.head;
            end = ref.head+ref.mSize;
        }
        public boolean hasNext(){
            return (ref.buffer[(start+1) % ref.mSize] != null) && start < end;
        }
        public T next(){
            if(hasNext()){
                return ref.buffer[start++ % ref.mSize];
            }
            return null;
        }
        public T[] toArray(){
            T[] out = (T[]) new Object[ref.mSize];
            for(int i =0;hasNext();i++){
                out[i] = next();
            }
            return out;
        }
    }
    
    public static final int kDefaultSize = 50;

    private final int mSize;
    private int head;
    private T[] buffer;

    /* need to be finished*/
    public CircularBuffer(int size){
        mSize = size;
        buffer = (T[]) new Object[size];
    }

    public T getHead(){
        return buffer[head];
    }

    public T get(int index){
        return buffer[(head+(int)Math.signum(index) *(Math.abs(index)%mSize))%mSize];
    }

    public T getTail(){
        return buffer[(head-1)%mSize];
    }

    public boolean add(T in){
        buffer[head++%mSize] = in;
        return true;
    }

    public boolean isEmpty(){
        return buffer[head] == null;
    }
    public int size(){
        return mSize;
    }

    public Iterator<T> iterator(){
        return new CircularBufferIterator<T>(this);
    }


}
