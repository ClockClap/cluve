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

package io.github.clockclap.cluve.spigot.v1_8;

import io.github.clockclap.cluve.common.CluveCommon;
import io.github.clockclap.cluve.common.CommonPlugin;
import io.github.clockclap.cluve.common.PluginType;
import io.github.clockclap.cluve.spigot.v1_8.world.CluveWorld;
import org.apache.commons.lang3.Validate;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CluveSpigot implements CluveCommon {

    private final Plugin spigotPlugin;
    private final CommonPlugin plugin;

    public CluveSpigot(@NotNull Plugin plugin) {
        Validate.notNull(plugin);
        this.spigotPlugin = plugin;
        this.plugin = new CommonPlugin(plugin.getName(), plugin.getDescription().getVersion(), PluginType.SPIGOT);
    }

    @NotNull
    @Override
    public CommonPlugin getPlugin() {
        return plugin;
    }

    @NotNull
    public Plugin getSpigotPlugin() {
        return spigotPlugin;
    }

    @NotNull
    public CluveWorld getCluveWorld(UUID uuid) {
        return CluveWorld.getCluveWorld(uuid, this);
    }
}
