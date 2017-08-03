/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author MikeX
 * @param <T>
 */
public class Tree<T> {
    
    private T head;
    
    private ArrayList<Tree<T>> leafs = new ArrayList<>();
    
    private Tree<T> parent = null;
    
    private HashMap<T, Tree<T>> locate = new HashMap<>();
    
    public Tree(T head){
        this.head = head;
        locate.put(head, this);
    }
    
    public Tree<T> addLeaf(T leaf){
        Tree<T> t = new Tree<>(leaf);
        leafs.add(t);
        t.parent = this;
        t.locate = this.locate;
        locate.put(leaf, t);
        return t;
    }
    
    public void addLeaf(T root, T leaf){
        if(locate.containsKey(root)){
            locate.get(root).addLeaf(leaf);
        }else{
            addLeaf(root).addLeaf(leaf);
        }
    }
    
    public Tree<T> setAsParent(T parentRoot){
        Tree<T> t = new Tree<>(parentRoot);
        t.leafs.add(this);
        this.parent = t;
        t.locate = this.locate;
        t.locate.put(head, this);
        t.locate.put(parentRoot, t);
        return t;
    }
    
    public T getHead(){
        return head;
    }
    
    public Tree<T> getTree(T element){
        return locate.get(element);
    }
    
    public Collection<T> getSuccessors(T root){
        Collection<T> successors = new ArrayList<>();
        Tree<T> tree = getTree(root);
        if(tree != null){
            for(Tree<T> leaf : tree.leafs){
                successors.add(leaf.head);
            }
        }
        return successors;
    }
    
    public Collection<Tree<T>> getSubTrees(){
        return leafs;
    }
    
    public static <T> Collection<T> getSuccessors(T of, Collection<Tree<T>> in){
        for(Tree<T> tree: in){
            if(tree.locate.containsKey(of)){
                return tree.getSuccessors(of);
            }
        }
        return new ArrayList<T>();
    }
    
    @Override
    public String toString() {
        return printTree(0);
    }

    private static final int indent = 2;

    private String printTree(int increment) {
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
          inc = inc + " ";
        }
        s = inc + head;
        for (Tree<T> child : leafs) {
          s += "\n" + child.printTree(increment + indent);
        }
        return s;
    }
}
