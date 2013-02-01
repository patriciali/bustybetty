import subprocess

names = ["abby", "alex", "alina", "becky", "cami", "carolyn", "charlotte", "evie", "fpack", "heather", "kathleen", "kelly", "kristen", "lily", "lisa", "liz", "maggie", "meaghan", "michelle", "monica", "neerja", "p$", "sluts"]
fbnames = ["abby.ostriker", "alex.hsu.5811", "alina.li", "beccavas", "camicat333", "carolyn.coyle.3", "charizarrd", "electronvoltage", "annie.holladay", "heather.soukup", "kathleen.hoza", "kelly.liu.9615", "kristen.murray.7739", "lily.steponaitis", "liuyang.lisa", "eadelaittre", "maggie.walker.3990", "meaghan.fitzgerald.90", "michelle.rybak", "monica.isava", "livelaughloveandlearn", "patriciazli", "alisha.schor"]

for (name, fbname) in zip(names, fbnames):
    link = 'http://graph.facebook.com/%s/picture?width=200&height=200' % (fbname)
    cmd = 'wget -O %s.jpg %s' % (name, link)
    subprocess.call(cmd.split())
