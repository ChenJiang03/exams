import index from "@/views/admin/index";
import modelList from "@/views/admin/model/ModelList";
import modelDetail from "@/views/admin/model/ModelDetail";
import ModelDetail from "@/views/admin/model/ModelDetail";
import ModelList from "@/views/admin/model/ModelList";
import UpdateQuestionCount from "@/views/admin/model/UpdateQuestionCount";
import ModelAdd from "@/views/admin/model/ModelAdd";
import PaperModelSave from "@/views/admin/model/PaperModelSave";


const routes=
    {
        path: '/admin/model',
        component:index,
        name:'index',
        children:[
            {
                path: 'list',
                name: 'modelList',
                component:ModelList
            },
            {
                path: 'detail',
                name: 'modelDetail',
                component:ModelDetail
            },
            {
                path: 'add',
                name: 'modelAdd',
                component: ModelAdd
            },
            {
                path: 'update',
                name: 'updateQuestionCount',
                component: UpdateQuestionCount
            },
            {
                path: 'save',
                name: 'paperModelSave',
                component: PaperModelSave
            }
        ]
    }







export default routes