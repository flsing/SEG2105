package com.example.eyobt.cook;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * class that stores all the methods and information for ingredients.
 */
public class Ingredient {
    String name,units;
    private Double quantity;
   private List<String> belongingRecipe;

    public Ingredient(String name){
        this.name=name;
    }

    public Ingredient(String name,Double quantity,String units) {
        this.quantity = quantity;
        this.name = name;
        this.units=units;
        belongingRecipe = new List<String>() {
            /**
             *
             * @return the size
             */
            @Override
            public int size() {
                return 0;
            }

            /**
             *
             * @return if it is empty or not
             */
            @Override
            public boolean isEmpty() {
                return false;
            }

            /**
             *
             * @param o object
             * @return if it contains the object
             */
            @Override
            public boolean contains(Object o) {
                return false;
            }

            /**
             *
             * @return null, it is the iterator
             */
            @NonNull
            @Override
            public Iterator<String> iterator() {
                return null;
            }

            /**
             *
             * @return convert the ingredient to an array
             */
            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            /**
             *
             * @param a the specific ingredient
             * @return the new array
             */
            @NonNull
            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            /**
             *
             * @param s the string of ingredient
             * @return return false
             */
            @Override
            public boolean add(String s) {
                return false;
            }

            /**
             *
             * @param o the ingredient you will be removing
             * @return false
             */
            @Override
            public boolean remove(Object o) {
                return false;
            }

            /**
             *
             * @param c the collection
             * @return returns whether it contains all or not
             */
            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            /**
             *
             * @param c The collection
             * @return false
             */
            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            /**
             *
             * @param index the index of where you will add
             * @param c the collection you will add
             * @return return false
             */
            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            /**
             *
             * @param c the collection you will be removing
             * @return return false
             */
            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            /**
             *
             * @param c the collection you will be retaining
             * @return
             */
            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            /**
             * clear the ingredient
             */
            @Override
            public void clear() {

            }

            /**
             *
             * @param index the index at which you want to get an ingredient
             * @return
             */
            @Override
            public String get(int index) {
                return null;
            }

            /**
             *
             * @param index the index at which you want to get an ingredient
             * @param element the ingriedent data you will set it to
             * @return
             */
            @Override
            public String set(int index, String element) {
                return null;
            }

            /**
             *
             * @param index the index at which you want to get an ingredient
             * @param element the ingriedent data you will add it to
             */
            @Override
            public void add(int index, String element) {

            }

            /**
             *
             * @param index the index at which you want to get an ingredient to remove it
             * @return
             */
            @Override
            public String remove(int index) {
                return null;
            }

            /**
             *
             * @param o the ingredient at which you will get the index of
             * @return the index of that object
             */
            @Override
            public int indexOf(Object o) {
                return 0;
            }

            /**
             *
             * @param o
             * @return the last index
             */
            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            /**
             *
             * @return
             */
            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            /**
             *
             * @param index the index at which you want to get an ingredient
             * @return
             */
            @NonNull
            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            /**
             *
             * @param fromIndex the starting index
             * @param toIndex the ending index
             * @return the sublist of the list
             */
            @NonNull
            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }
}
