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

package io.github.clockclap.cluve.common;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

public class CommonPlugin {

    private final String name;
    private final String version;
    private final PluginType type;

    public CommonPlugin(@NotNull String name, @NotNull String version, @NotNull PluginType type) {
        Validate.notNull(name);
        Validate.notNull(version);
        Validate.notNull(type);
        this.name = name;
        this.version = version;
        this.type = type;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getVersion() {
        return version;
    }

    @NotNull
    public PluginType getType() {
        return type;
    }

}
