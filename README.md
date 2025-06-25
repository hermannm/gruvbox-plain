<img alt="gruvbox-plain logo with cold color scheme" width="75" height="75" src="https://github.com/hermannm/gruvbox-plain/blob/assets/logos/gruvbox-plain-cold.png?raw=true" /><img alt="gruvbox-plain logo with warm color scheme" width="75" height="75" src="https://github.com/hermannm/gruvbox-plain/blob/assets/logos/gruvbox-plain-warm.png?raw=true" />

# gruvbox-plain

Code editor theme for IntelliJ-based IDEs and VSCode, based on [`morhetz/gruvbox`](https://github.com/morhetz/gruvbox)
but with a plainer color palette. Comes with a cold and a warm variant.

**Contents**

- [Screenshots](#screenshots)
- [Color Scheme](#color-scheme)
- [Installation](#installation)
- [Credits](#credits)

## Screenshots

`gruvbox-plain-cold` in IntelliJ:

![Screenshot of gruvbox-plain-cold theme in IntelliJ editor](https://github.com/hermannm/gruvbox-plain/blob/assets/screenshots/gruvbox-plain-cold-intellij.png?raw=true)

`gruvbox-plain-warm` in VSCode:

![Screenshot of gruvbox-plain-warm theme in VSCode editor](https://github.com/hermannm/gruvbox-plain/blob/assets/screenshots/gruvbox-plain-warm-vscode.png?raw=true)

## Color Scheme

`gruvbox-plain` uses a limited subset of the gruvbox dark mode color palette. The table below shows the general usage of
the different colors.

|                                        Usage |                                        `gruvbox-plain-cold`                                        |                                        `gruvbox-plain-warm`                                        |
|---------------------------------------------:|:--------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------:|
|            Variables, properties, plain text | `#ebdbb2`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/ebdbb2.png?raw=true) | `#ebdbb2`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/ebdbb2.png?raw=true) |
|                          Keywords, operators | `#d3869b`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/d3869b.png?raw=true) | `#fe8019`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/fe8019.png?raw=true) |
| Types, classes, namespaces, components, tags | `#83a598`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/83a598.png?raw=true) | `#fabd2f`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/fabd2f.png?raw=true) |
|                           Functions, methods | `#b8bb26`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/b8bb26.png?raw=true) | `#b8bb26`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/b8bb26.png?raw=true) |
|                   Values, language constants | `#8ec07c`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/8ec07c.png?raw=true) | `#8ec07c`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/8ec07c.png?raw=true) |
|                                  Punctuation | `#a89984`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/a89984.png?raw=true) | `#a89984`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/a89984.png?raw=true) |
|                      Comments, documentation | `#928374`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/928374.png?raw=true) | `#928374`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/928374.png?raw=true) |
|                             Background color | `#282828`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/282828.png?raw=true) | `#282828`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/282828.png?raw=true) |

For edge cases in languages where these may not apply, the color deemed most appropriate has been chosen. This can
always be overridden under `Preferences` -> `Editor` -> `Color Scheme` in IntelliJ-based IDEs, or
`editor.tokenColorCustomizations` in VSCode's `settings.json`.

## Installation

### IntelliJ-based IDEs

1. Go to the [Releases page](https://github.com/hermannm/gruvbox-plain/releases)
2. Download the latest `gruvbox-plain-intellij-[version].zip` under Assets
3. Open up `Settings` in your IDE
4. Go to the `Plugins` tab
5. Click the cogwheel in the top bar
6. Click `Install Plugin from Disk...`, and select the downloaded `.zip` file

Now `gruvbox-plain-cold` and `gruvbox-plain-warm` should be available under `Settings` -> `Appearance & Behavior` ->
`Appearance` -> `Theme`!

### VSCode

1. Go to the [Releases page](https://github.com/hermannm/gruvbox-plain/releases)
2. Download the latest `gruvbox-plain-vscode-[version].vsix` under Assets
3. Go to the `Extensions` tab in VSCode
4. Click `...` in the top right of the tab
5. Click `Install from VSIX...`, and select the downloaded `.vsix` file

Now `gruvbox-plain-cold` and `gruvbox-plain-warm` should be available under `Settings` -> `Workbench: Color Theme`!

## Credits

- [`morhetz/gruvbox`](https://github.com/morhetz/gruvbox) for the original color scheme
    - _Copyright (c) 2017 Pavel Pertsev, [MIT/X11 license](https://github.com/morhetz/gruvbox#license)_
- [`jdinhify/vscode-theme-gruvbox`](https://github.com/jdinhify/vscode-theme-gruvbox) for the base VSCode UI theme
    - _Copyright (c) 2017 JD, [MIT license](https://github.com/jdinhify/vscode-theme-gruvbox/blob/main/LICENSE)_
- [`Vincent-P/gruvbox-intellij-theme`](https://github.com/Vincent-P/gruvbox-intellij-theme) for the base IntelliJ UI
  theme
    - _Copyright (c) 2019 Vincent Parizet,
      [MIT license](https://github.com/Vincent-P/gruvbox-intellij-theme/blob/master/LICENSE)_
