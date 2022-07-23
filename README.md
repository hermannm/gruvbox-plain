<div align="center">
  <img alt="logo" src="./vscode/img/gruvbox-plain-warm_logo.png"><img alt="logo" src="./vscode/img/gruvbox-plain-cold_logo.png">
</div>
<h1 align="center">gruvbox-plain</h1>

Editor theme for VSCode and JetBrains IDEs, based on [morhetz/gruvbox](https://github.com/morhetz/gruvbox) but with a plainer color palette for syntax highlighting. The theme comes with two palettes: `gruvbox-plain-warm` and `gruvbox-plain-cold` (latter only available for VSCode).

## Color Scheme

gruvbox-plain uses a limited subset of the gruvbox dark mode color palette for syntax highlighting. The table below shows the general usage of the different colors.

|                                        Usage |                         `gruvbox-plain-warm`                          |                         `gruvbox-plain-cold`                          |
| -------------------------------------------: | :-------------------------------------------------------------------: | :-------------------------------------------------------------------: |
|            Variables, properties, plain text | `#ebdbb2`<br>![](https://via.placeholder.com/15/ebdbb2/000000?text=+) | `#ebdbb2`<br>![](https://via.placeholder.com/15/ebdbb2/000000?text=+) |
|                          Keywords, operators | `#fe8019`<br>![](https://via.placeholder.com/15/fe8019/000000?text=+) | `#d3869b`<br>![](https://via.placeholder.com/15/d3869b/000000?text=+) |
| Types, classes, namespaces, components, tags | `#fe8019`<br>![](https://via.placeholder.com/15/fabd2f/000000?text=+) | `#83a598`<br>![](https://via.placeholder.com/15/83a598/000000?text=+) |
|                           Functions, methods | `#b8bb26`<br>![](https://via.placeholder.com/15/b8bb26/000000?text=+) | `#b8bb26`<br>![](https://via.placeholder.com/15/b8bb26/000000?text=+) |
|                   Values, language constants | `#8ec07c`<br>![](https://via.placeholder.com/15/8ec07c/000000?text=+) | `#8ec07c`<br>![](https://via.placeholder.com/15/8ec07c/000000?text=+) |
|                                  Punctuation | `#a89984`<br>![](https://via.placeholder.com/15/a89984/000000?text=+) | `#a89984`<br>![](https://via.placeholder.com/15/a89984/000000?text=+) |
|                      Comments, documentation | `#928374`<br>![](https://via.placeholder.com/15/928374/000000?text=+) | `#928374`<br>![](https://via.placeholder.com/15/928374/000000?text=+) |
|                             Background color | `#282828`<br>![](https://via.placeholder.com/15/282828/000000?text=+) | `#282828`<br>![](https://via.placeholder.com/15/282828/000000?text=+) |

For edge cases in languages where these may not apply, the color deemed most appropriate has been chosen. This can always be overridden under `editor.tokenColorCustomizations` in VSCode's `settings.json`, or `Preferences -> Editor -> Color Scheme` in JetBrains IDEs.

## Credits

- [morhetz/gruvbox](https://github.com/morhetz/gruvbox) for the original color scheme
  - _Copyright (c) 2017 Pavel Pertsev, [MIT/X11 license](https://github.com/morhetz/gruvbox#license)_
- [jdinhify/vscode-theme-gruvbox](https://github.com/jdinhify/vscode-theme-gruvbox) for the base VSCode UI theme
  - _Copyright (c) 2017 JD, [MIT license](https://github.com/jdinhify/vscode-theme-gruvbox/blob/main/LICENSE)_
- [Vincent-P/gruvbox-intellij-theme](https://github.com/Vincent-P/gruvbox-intellij-theme) for the base JetBrains UI theme
  - _Copyright (c) 2019 Vincent Parizet, [MIT license](https://github.com/Vincent-P/gruvbox-intellij-theme/blob/master/LICENSE)_
