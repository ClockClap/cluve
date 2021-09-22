/*
 * Copyright (c) 2021, ClockClap. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package io.github.cluve.spigot.v1_16.world;

import org.bukkit.Location;

public final class FillSize {

    int x;
    int y;
    int z;

    public FillSize(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public FillSize(Location a, Location b) {
        this.x = b.getBlockX() - a.getBlockX();
        this.y = b.getBlockY() - a.getBlockY();
        this.z = b.getBlockZ() - a.getBlockZ();
    }

    public FillSize(int xa, int ya, int za, int xb, int yb, int zb) {
        this.x = xb - xa;
        this.y = yb - ya;
        this.z = zb - za;
    }

    public int getSizeX() {
        return x;
    }

    public int getSizeY() {
        return y;
    }

    public int getSizeZ() {
        return z;
    }
}
