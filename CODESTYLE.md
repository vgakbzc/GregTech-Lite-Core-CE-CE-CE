It is recommended to use IntelliJ IDEA as your workspace, and please review the following suggestions:

# IDEA Plugin Requirements

For developing this mod, the [Lombok Plugin](https://plugins.jetbrains.com/plugin/6317-lombok) for IntelliJ IDEA is strictly required.
Additionally, the [Minecraft Development Plugin](https://plugins.jetbrains.com/plugin/8327-minecraft-development) is recommended.

# How to build this Mod in IDEA?

At first, please download or clone this mod at [GregTech Lite Core](https://gitlab.com/sweep_tosho/gregtech-lite-core).
Then, you can begin to build Gradle (we use Gradle 8.1.1), and some dependencies will download at this time.

## Total Dependencies list of this mod

These Files will be imported in Gradle for this mod.

### Strictly Required Dependencies
- Retro Futura Gradle (version: 1.3.28)
- Curse Gradle (version: 1.4.0)
- Jabel (version: 1.0.0)
- JNA Platform (version: 5.13.0)
- Java 8 Unsupported Shim (version: 1.0.0)
- Jetbrains Annotations (version: 24.1.0)
- Lombok (version: 1.18.24)
- CleanroomMC Assetmover (version: 2.5)
- Mixinbooter (version: 9.1)
- ASM (version: 5.2)
- Google Guava (version: 24.1.1)
- Google Gson (version: 2.8.6)

### Hard Dependencies
- Code Chicken Lib (version: 3.2.3.358)
- Modular UI (version: 2.4.3)
- GregTech CE Unofficial (version: 2.8.10-beta)
- Gregicality Multiblocks (version: 1.2.10)
- GregTech Food Option (version: 1.11.3)
- AE2 Unofficial Extended Life (version: 0.56.6)
- AE2 Fluid Crafting Rework (version: 2.6.3r)
- Neeve's AE2 Additions (version: 1.6.4)
- Lib Nine (version: 1.2.1)
- Lazy AE2 (version: 1.1.2.6)
- BD Lib (version: 1.14.4.1)
- AE2 Stuff Unofficial (version: 0.9)
- Had Enough Items (version: 4.25.5)
- The One Probe (version: 1.4.28)

### Compile Time Only Dependencies
- CraftTweaker 2 API (version: 4.1.20.684)
- Connected Textures Mod (version: 1.0.2.31)

### Soft Dependencies, Compile Time Declaration
- Actually Additions (version: r152)
- Architecture Craft (version: 3.108)
- Chisel (version: 1.0.2.45)
- Extra Utilities 2 (version: 1.9.9)
- Groovy Script (version: 0.7.0)
- Top Addons (version: 1.13.0)

### Soft Dependencies, Runtime Time Declaration
- Spark (version: 1.6.3, Optional)
- Smooth Font (version: 2.1.4, Optional)

# Naming Conventions
- Standard Java class naming convention (`UpperCamelCase`).
- Standard Java field & method naming convention (`lowerCamelCase`).
- Used `lower_camel_case` for registry entries, string constant identifiers and keys.
- Used `UPPER_CAMEL_CASE` for some special parameters.

# Class conventions:
- Do not add unused code, like public modifiers in interfaces (though IDEA reports these just fine).
- Fields are always declared in top of class, please use Lombok `@Getter`/`@Setter` to get/set these in common.
- Use `this.someField` when changing self field value (makes code easier to understand without IDEA).
- Dedicate big logic into multiple methods.
- Do not have >1 nested classes, just create them in dedicated source files.
- Use blanks lines to dedicate logic statements in methods.

# Minecraft-specific:
- Avoid marking things as tickable or having tile entities unless absolutely required.
- If creating interface in API, it's recommended to implement it as capability.
- Implement capabilities in dedicated classes.
- Always use `GTLiteLog.logger` for logging purposes (do not use default `Log` or `GTLog`).
- Use mutable block pos if doing something often or comparing many blocks (and mutable objects in general).
- Prefer widget system in Internal `ModularUI` (in `gregtech`) or Modular UI 2 mod to direct drawing in UI.

__Hint__: You do not have to completely follow them suggestions, these are just to help us maintain the overall code style.