﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DTO.requests
{
    public class TagRequestTo
    {
        [StringLength(32, MinimumLength = 2)]
        public string Name { get; set; } = string.Empty;
    }
}
