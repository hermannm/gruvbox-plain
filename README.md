<div align="center">
  <img alt="logo" src="./vscode/img/gruvbox-plain-cold_logo.png"><img alt="logo" src="./vscode/img/gruvbox-plain-warm_logo.png">
</div>
<h1 align="center">gruvbox-plain</h1>

Code editor theme for VSCode and IntelliJ-based IDEs, based on [`morhetz/gruvbox`](https://github.com/morhetz/gruvbox) but with a plainer color palette for syntax highlighting. The theme comes with two palettes: `gruvbox-plain-cold` and `gruvbox-plain-warm`.

**Contents**

- [Color Scheme](#color-scheme)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Credits](#credits)

## Color Scheme

`gruvbox-plain` uses a limited subset of the gruvbox dark mode color palette for syntax highlighting. The table below shows the general usage of the different colors.

|                                        Usage |                                        `gruvbox-plain-cold`                                        |                                        `gruvbox-plain-warm`                                        |
| -------------------------------------------: | :------------------------------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------: |
|            Variables, properties, plain text | `#ebdbb2`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/ebdbb2.png?raw=true) | `#ebdbb2`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/ebdbb2.png?raw=true) |
|                          Keywords, operators | `#d3869b`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/d3869b.png?raw=true) | `#fe8019`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/fe8019.png?raw=true) |
| Types, classes, namespaces, components, tags | `#83a598`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/83a598.png?raw=true) | `#fabd2f`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/fabd2f.png?raw=true) |
|                           Functions, methods | `#b8bb26`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/b8bb26.png?raw=true) | `#b8bb26`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/b8bb26.png?raw=true) |
|                   Values, language constants | `#8ec07c`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/8ec07c.png?raw=true) | `#8ec07c`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/8ec07c.png?raw=true) |
|                                  Punctuation | `#a89984`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/a89984.png?raw=true) | `#a89984`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/a89984.png?raw=true) |
|                      Comments, documentation | `#928374`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/928374.png?raw=true) | `#928374`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/928374.png?raw=true) |
|                             Background color | `#282828`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/282828.png?raw=true) | `#282828`<br>![](https://github.com/hermannm/gruvbox-plain/blob/assets/colors/282828.png?raw=true) |

For edge cases in languages where these may not apply, the color deemed most appropriate has been chosen. This can always be overridden under `editor.tokenColorCustomizations` in VSCode's `settings.json`, or `Preferences -> Editor -> Color Scheme` in IntelliJ-based IDEs.

## Screenshots

<p align="center">
    <img alt="gruvbox-plain-cold" src="https://github.com/hermannm/gruvbox-plain/blob/assets/gruvbox-plain-cold-vscode.png?raw=true">
    <br />
    <code>gruvbox-plain-cold</code><em> in VSCode</em>
</p>

<br />

<p align="center">
  <img alt="gruvbox-plain-warm" src="https://github.com/hermannm/gruvbox-plain/blob/assets/gruvbox-plain-warm-intellij.png?raw=true">
  <br />
  <code>gruvbox-plain-warm</code><em> in IntelliJ</em>
</p>

## Installation

Go to the [Releases page](https://github.com/hermannm/gruvbox-plain/releases), and follow the instructions to install the theme for your editor.

## Credits

- [`morhetz/gruvbox`](https://github.com/morhetz/gruvbox) for the original color scheme
  - _Copyright (c) 2017 Pavel Pertsev, [MIT/X11 license](https://github.com/morhetz/gruvbox#license)_
- [`jdinhify/vscode-theme-gruvbox`](https://github.com/jdinhify/vscode-theme-gruvbox) for the base VSCode UI theme
  - _Copyright (c) 2017 JD, [MIT license](https://github.com/jdinhify/vscode-theme-gruvbox/blob/main/LICENSE)_
- [`Vincent-P/gruvbox-intellij-theme`](https://github.com/Vincent-P/gruvbox-intellij-theme) for the base IntelliJ UI theme
  - _Copyright (c) 2019 Vincent Parizet, [MIT license](https://github.com/Vincent-P/gruvbox-intellij-theme/blob/master/LICENSE)_
