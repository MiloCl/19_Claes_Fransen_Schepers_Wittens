package controller;

import model.domain.MetroCard;

import java.util.TreeMap;

public interface Observer {
    void update(TreeMap<String, MetroCard> metroCards);
}
