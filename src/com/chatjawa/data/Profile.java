/*
 * ChatJawa is a Star Wars: The Old Republic tool for managing chat settings
 * across multiple characters.
 *
 * Copyright (C) 2015 ChatJawa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.chatjawa.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waverunner on 5/13/2015
 */
public class Profile {

    public static final String CHARACTERS = "Characters";
    public static final String PROFILES = "Profiles";

    private String name;
    private String parent;
    private List<ChatTab> tabs;
    private ColorProfile colors;
    private boolean timestamps;

    private boolean dirty = false;

    public Profile() {
        this.tabs = new ArrayList<>();
        this.parent = "";
    }

    public Profile(String name, List<ChatTab> tabs, boolean timestamps) {
        this.name = name;
        this.tabs = tabs;
        this.timestamps = timestamps;
        this.parent = "";
    }

    public Profile(String rootName) {
        this.name = rootName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatTab> getTabs() {
        return tabs;
    }

    public void setTabs(List<ChatTab> tabs) {
        this.tabs = tabs;
    }

    public boolean isTimestampsEnabled() {
        return timestamps;
    }

    public void setTimestamps(boolean timestamps) {
        this.timestamps = timestamps;
    }

    public ColorProfile getColors() {
        return colors;
    }

    public void setColors(ColorProfile colors) {
        this.colors = colors;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = (parent != null ? parent : "");
    }

    public void copyFrom(Profile parent, boolean timestamps) {
        tabs = parent.getTabs();
        colors = parent.getColors();
        this.parent = parent.toString();

        if (timestamps)
            this.timestamps = timestamps;
    }

    public boolean isRoot() {
        return (getName().equals(CHARACTERS) || getName().equals(PROFILES));
    }

    @Override
    public String toString() {
        return getName();
    }
}
