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

package io.github.cluve.spigot.v1_13.world;

import io.github.cluve.common.MinecraftVersion;
import io.github.cluve.common.PluginType;
import io.github.cluve.common.annotation.SupportedTypes;
import io.github.cluve.common.annotation.SupportedVersions;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.Collection;

@SupportedTypes({
        PluginType.SPIGOT,
        PluginType.PAPER
})
@SupportedVersions(versions = { MinecraftVersion.V1_13 })
public class FillPattern {

    Material[] pattern;
    FillSize size;

    public FillPattern(FillSize size) {
        this.pattern = new Material[size.x * size.y * size.z];
        this.size = size;
    }

    public FillPattern(int sizeX, int sizeY, int sizeZ) {
        this.pattern = new Material[sizeX * sizeX * sizeZ];
        this.size = new FillSize(sizeX, sizeY, sizeZ);
    }

    public FillPattern(FillSize size, Material fillBlock) {
        this.pattern = new Material[size.x * size.y * size.z];
        this.size = size;
        Arrays.fill(pattern, fillBlock);
    }

    public FillPattern(int sizeX, int sizeY, int sizeZ, Material fillBlock) {
        this.pattern = new Material[sizeX * sizeX * sizeZ];
        this.size = new FillSize(sizeX, sizeY, sizeZ);
        Arrays.fill(pattern, fillBlock);
    }

    public Material get(PatternLocation loc) {
        int mx = size.x;
        int my = size.y;
        int mz = size.z;
        if(loc.x <= mx && loc.y <= my && loc.z <= mz) {
            int yz = my * mz;
            int i = loc.z + loc.y * mz + loc.x * yz;
            Material r = pattern[i];
            if(r == null) return Material.AIR;
            return r;
        }
        return null;
    }

    public Material get(int x, int y, int z) {
        int mx = size.x;
        int my = size.y;
        int mz = size.z;
        if(x <= mx && y <= my && z <= mz) {
            int yz = my * mz;
            int i = z + y * mz + x * yz;
            Material r = pattern[i];
            if(r == null) return Material.AIR;
            return r;
        }
        return null;
    }

    public Material put(PatternLocation loc, Material material) {
        int x = size.x;
        int y = size.y;
        int z = size.z;
        if(loc.x <= x && loc.y <= y && loc.z <= z) {
            int yz = y * z;
            int i = loc.z + loc.y * z + loc.x * yz;
            pattern[i] = material;
        }
        return material;
    }

    public Material put(int x, int y, int z, Material material) {
        int mx = size.x;
        int my = size.y;
        int mz = size.z;
        if(x <= mx && y <= my && z <= mz) {
            int yz = my * mz;
            int i = z + y * mz + x * yz;
            pattern[i] = material;
        }
        return material;
    }

    public FillSize getSize() {
        return size;
    }

    public Collection<Material> toCollection() {
        return Arrays.asList(pattern);
    }

}
