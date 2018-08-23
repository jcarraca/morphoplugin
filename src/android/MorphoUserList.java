package com.jcarraca.cordova.plugin;

import java.util.ArrayList;

public class MorphoUserList {
    private ArrayList<MorphoUser> morphoUsers = new ArrayList();

    public MorphoUser getUser(int index) {
        if (index < this.morphoUsers.size()) {
            return (MorphoUser) this.morphoUsers.get(index);
        }
        return null;
    }

    public int getNbUser() {
        return this.morphoUsers.size();
    }

    private void addUser(MorphoUser morphoUser) {
        if (morphoUser != null) {
            this.morphoUsers.add(morphoUser);
        }
    }
}
