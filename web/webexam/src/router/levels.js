import index from "@/views/admin/index"
import LevelsList from "@/views/levels/LevelsList";
import LevelsAdd from "@/views/levels/LevelsAdd";
import LevelsUpdate from "@/views/levels/LevelsUpdate";

const routes=
    {
        path: '/levels',
        name:'index',
        component:index,
        children:[
            {
                path: 'list',
                name: 'levelsList',
                component:LevelsList
            },
            {
                path: 'add',
                name: 'levelsAdd',
                component:LevelsAdd
            },
            {
                path: 'update',
                name: 'levelsUpdate',
                component:LevelsUpdate
            }

        ]

    }


export default routes