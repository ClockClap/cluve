/*
 * Copyright (c) 2021, ClockClap. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package io.github.cluve.common;

/**
 * All plugin types.
 */
public enum PluginType {

    BUKKIT(0, "Bukkit"),
    SPIGOT(1, "Spigot"),
    PAPER(2, "Paper"),
    BUNGEE_CORD(10, "BungeeCord"),
    WATERFALL(11, "Waterfall"),
    VELOCITY(12, "Velocity"),
    SPONGE(20, "Sponge"),
    OTHERS(-1, "Others");

    private String name;
    private int id;

    PluginType(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static boolean isProxy(PluginType type) {
        return type.getId() >= 10 && type.getId() < 20;
    }

}
