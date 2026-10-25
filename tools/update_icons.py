import urllib.request
import json
import re

file_path = 'shared/src/commonMain/kotlin/omstu/pin252t/ryazanov/data/MockMods.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

slugs = re.findall(r'slug = "([^"]+)"', content)
print('Found slugs:', len(slugs))

updates = {}
for s in slugs:
    try:
        url = f'https://api.modrinth.com/v2/project/{s}'
        req = urllib.request.Request(url, headers={'User-Agent': 'ModListApp/1.0'})
        res = urllib.request.urlopen(req)
        data = json.loads(res.read().decode('utf-8'))
        icon = data.get('icon_url') or data.get('raw_icon_url')
        if icon:
            updates[s] = icon
            print(f'{s} -> {icon}')
    except Exception as e:
        print(f'Error for {s}: {e}')

for s, icon in updates.items():
    pattern = rf'(slug = "{s}",[\s\S]*?iconUrl = ")[^"]+(")'
    content = re.sub(pattern, rf'\g<1>{icon}\g<2>', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print('Done updating MockMods.kt!')
